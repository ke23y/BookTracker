package com.example.etta.booktracker

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.etta.booktracker.Adapter.FinishedAdapter
import com.example.etta.booktracker.data.*
import com.example.etta.booktracker.dialogues.DialogueFinished
import com.example.etta.booktracker.dialogues.DialogueReading
import com.example.etta.booktracker.touch.BookTouchHelperCallback
import kotlinx.android.synthetic.main.activity_finished.*

class FinishedActivity : AppCompatActivity(),DialogueFinished.FinishedHandler {
    companion object {
        val FINISHED_BOOK_TO_EDIT = "FINISHED_BOOK_TO_EDIT"
    }

    private lateinit var finishedAdapter: FinishedAdapter

    private var editIndex:Int =0  //help us to remember which number is in the edit mode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)
        setSupportActionBar(toolbar_finished)
        fabAdd_Finished.setOnClickListener { view ->
            showItem()

        }
        initRecyclerView()

        setUpDrawer()
    }

    private fun setUpDrawer() {
        //mDrawerLayout = findViewById(R.id.activity_to_read)

        val navigationView: NavigationView = findViewById(R.id.nav_view_finished)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            activity_finished.closeDrawers()

            if(menuItem.itemId== R.id.menu_toread) {
                openToReadList()
            }
            else if (menuItem.itemId== R.id.menu_about) {
                Toast.makeText(this@FinishedActivity, getString(R.string.str_about), Toast.LENGTH_SHORT).show()

            }
            else if (menuItem.itemId == R.id.menu_reading) {
                openReadingList()
            }
            else if (menuItem.itemId == R.id.menu_finished) {


            }
            else if (menuItem.itemId == R.id.menu_search) {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }


            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true


        }
    }

    /** Called when the user taps Reading button  button */
    private fun openReadingList() {
        //val editText = findViewById<EditText>(R.id.editText)
        //val message = editText.text.toString()
        val intent = Intent(this, ReadingActivity::class.java)
        startActivity(intent)
    }

    private fun openToReadList() {
        //val editText = findViewById<EditText>(R.id.editText)
        //val message = editText.text.toString()
        val intent = Intent(this, ToReadActivity::class.java)
        startActivity(intent)
    }

    private fun initRecyclerView() {
        Thread {

            //Get the todoList
            val itemList = FinishedDataBase.getInstance(this@FinishedActivity).finishedBookDAO().findAllItems()

            finishedAdapter = FinishedAdapter(this@FinishedActivity, itemList)

            runOnUiThread {
                //Added

                recyclerFinished.adapter = finishedAdapter //This line need to be in the tread because if it is outside, it is possible
                //that the this line is executed before the thread. Because thread is happening parallel

                val callback = BookTouchHelperCallback(finishedAdapter)
                val touchHelper = ItemTouchHelper(callback)
                touchHelper.attachToRecyclerView(recyclerFinished)
            }

        }.start()
    }

    public fun showFinishedDialog(itemToEdit: FinishedBook, idx: Int) { //idx: 0,1,2,3... depends on which item we edit
        editIndex = idx
        val editItemDialog = DialogueFinished()

        val bundle = Bundle()

        bundle.putSerializable(FinishedActivity.FINISHED_BOOK_TO_EDIT, itemToEdit)
        editItemDialog.arguments = bundle

        editItemDialog.show(supportFragmentManager,
            "EDITITEMDIALOGFINISHED")

    }


    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_add_finished, menu);
        return true;
    }


    private fun showItem() {
        DialogueFinished().show(supportFragmentManager, "TAG_CREATE_FINISHED")
        //initSpinner()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.itemId

        //Add a new item to the shopping list
        if (id == R.id.action_add_finished) {
            showItem()
            return true;
        }
        else if (id == R.id.action_deleteAll_finished) {
            deleteAll()

            return true;
        }
        else if (id == R.id.show_finished_state) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }



    override fun finishedCreated(item: FinishedBook) {
        //Everytime we need to access the database, we need to do this.
        Thread { //Added

            val id = FinishedDataBase.getInstance(this@FinishedActivity).finishedBookDAO().insertItem(item)  //Access the database
            item.itemID = id

            //We can't change UI from another thread, so we need to specify that it is run on the same thread
            runOnUiThread{
                finishedAdapter.addItem(item)
            }
        }.start()

    }

    //Update the database (instead of inserting doto into database
    override fun finishedUpdated(item: FinishedBook) {
        val dbThread = Thread {

            FinishedDataBase.getInstance(this@FinishedActivity).finishedBookDAO().updateItem(item)

            runOnUiThread { finishedAdapter.updateToBuy(item, editIndex) }
        }
        dbThread.start()

    }

    private fun deleteAll() {
        Thread {
            FinishedDataBase.getInstance(this@FinishedActivity).finishedBookDAO().deleteAll()
            runOnUiThread {
                finishedAdapter.deleteAll()
            }
        }.start()
    }

}

