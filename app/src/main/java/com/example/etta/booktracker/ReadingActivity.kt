package com.example.etta.booktracker

import android.content.Intent
import android.os.Bundle
import android.support.annotation.RequiresPermission
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.etta.booktracker.Adapter.BookAdapter
import com.example.etta.booktracker.Adapter.ReadingAdapter
import com.example.etta.booktracker.data.AppDatabase
import com.example.etta.booktracker.data.Book
import com.example.etta.booktracker.data.ReadingBook
import com.example.etta.booktracker.data.ReadingDataBase
import com.example.etta.booktracker.dialogues.DialogueReading
import com.example.etta.booktracker.dialogues.DialogueToRead
import com.example.etta.booktracker.touch.BookTouchHelperCallback
import kotlinx.android.synthetic.main.activity_reading.*
import kotlinx.android.synthetic.main.activity_to_read.*

class ReadingActivity : AppCompatActivity(),DialogueReading.ReadingHandler {

    companion object {
        val READING_BOOK_TO_EDIT = "READING_BOOK_TO_EDIT"
    }

    private lateinit var readingAdapter: ReadingAdapter

    private var editIndex:Int =0  //help us to remember which number is in the edit mode


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)
        setSupportActionBar(toolbar_reading)
        fabAdd_reading.setOnClickListener { view ->
            showItem()
        }

        initRecyclerView()


        setUpDrawer()
    }

    private fun setUpDrawer() {
        //mDrawerLayout = findViewById(R.id.activity_to_read)

        val navigationView: NavigationView = findViewById(R.id.nav_view_reading)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            activity_reading.closeDrawers()

            if(menuItem.itemId== R.id.menu_toread) {
                //showAddTodoDialog()
                openToReadList()
            }
            else if (menuItem.itemId== R.id.menu_about) {
                Toast.makeText(this@ReadingActivity, getString(R.string.str_about), Toast.LENGTH_SHORT).show()

            }
            else if (menuItem.itemId == R.id.menu_reading) {

            }
            else if (menuItem.itemId == R.id.menu_finished) {
                openFinishedList()

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
    private fun openToReadList() {
        //val editText = findViewById<EditText>(R.id.editText)
        //val message = editText.text.toString()
        val intent = Intent(this, ToReadActivity::class.java)
        startActivity(intent)
    }

    private fun openFinishedList() {
        //val editText = findViewById<EditText>(R.id.editText)
        //val message = editText.text.toString()
        val intent = Intent(this, FinishedActivity::class.java)
        startActivity(intent)
    }


    private fun initRecyclerView() {
        Thread {

            //Get the todoList
            val itemList = ReadingDataBase.getInstance(this@ReadingActivity).readingBookDAO().findAllItems()

            readingAdapter = ReadingAdapter(this@ReadingActivity, itemList)

            runOnUiThread {
                //Added

                recyclerReading.adapter = readingAdapter //This line need to be in the tread because if it is outside, it is possible
                //that the this line is executed before the thread. Because thread is happening parallel

                val callback = BookTouchHelperCallback(readingAdapter)
                val touchHelper = ItemTouchHelper(callback)
                touchHelper.attachToRecyclerView(recyclerReading)
            }

        }.start()
    }

    public fun showReadingDialog(itemToEdit: ReadingBook, idx: Int) { //idx: 0,1,2,3... depends on which item we edit
        editIndex = idx
        val editItemDialog = DialogueReading()

        val bundle = Bundle()

        bundle.putSerializable(ReadingActivity.READING_BOOK_TO_EDIT, itemToEdit)
        editItemDialog.arguments = bundle

        editItemDialog.show(supportFragmentManager,
            "EDITITEMDIALOGREADING")

    }


    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_add_reading, menu);
        return true;
    }


    private fun showItem() {
        DialogueReading().show(supportFragmentManager, "TAG_CREATE_READING")
        //initSpinner()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.itemId

        //Add a new item to the shopping list
        if (id == R.id.action_add_reading) {
            showItem()
            return true;
        }
        else if (id == R.id.action_deleteAll_reading) {
            deleteAll()

            return true;
        }
        else if (id == R.id.show_reading_state) {
            return true;
        }
        return super.onOptionsItemSelected(item);


    }



    override fun readingCreated(item: ReadingBook) {
        //Everytime we need to access the database, we need to do this.
        Thread { //Added

            val id = ReadingDataBase.getInstance(this@ReadingActivity).readingBookDAO().insertItem(item)  //Access the database
            item.itemID = id

            //We can't change UI from another thread, so we need to specify that it is run on the same thread
            runOnUiThread{
                readingAdapter.addItem(item)
            }
        }.start()

    }

    //Update the database (instead of inserting doto into database
    override fun readingUpdated(item: ReadingBook) {
        val dbThread = Thread {

            ReadingDataBase.getInstance(this@ReadingActivity).readingBookDAO().updateItem(item)

            runOnUiThread { readingAdapter.updateToBuy(item, editIndex) }
        }
        dbThread.start()

    }

    private fun deleteAll() {
        Thread {
            ReadingDataBase.getInstance(this@ReadingActivity).readingBookDAO().deleteAll()
            runOnUiThread {
                readingAdapter.deleteAll()
            }
        }.start()
    }

}

