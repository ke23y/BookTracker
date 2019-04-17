package com.example.etta.booktracker

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.etta.booktracker.Adapter.BookAdapter
import com.example.etta.booktracker.data.AppDatabase
import com.example.etta.booktracker.data.Book
import com.example.etta.booktracker.dialogues.DialogueToRead
import com.example.etta.booktracker.touch.BookTouchHelperCallback
import kotlinx.android.synthetic.main.activity_to_read.*

class ToReadActivity : AppCompatActivity(), DialogueToRead.ItemHandler {

    companion object {
        val KEY_ITEM_TO_EDIT = "KEY_ITEM_TO_EDIT"
    }

    private lateinit var itemAdapter: BookAdapter

    private var editIndex:Int =0  //help us to remember which number is in the edit mode


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_read)
        setSupportActionBar(toolbar)
        fabAddTodo.setOnClickListener { view ->
            showItem()
        }
        //actionBar.setTitle("To Read")

        setUpDrawer();
        initRecyclerView();
    }

    private fun setUpDrawer() {
        //mDrawerLayout = findViewById(R.id.activity_to_read)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            activity_to_read.closeDrawers()

            if(menuItem.itemId== R.id.menu_toread) {
                //showAddTodoDialog()
            }
            else if (menuItem.itemId== R.id.menu_about) {
                Toast.makeText(this@ToReadActivity, getString(R.string.str_about), Toast.LENGTH_SHORT).show()

            }
            else if (menuItem.itemId == R.id.menu_reading) {
                openReadingList()
            }
            else if (menuItem.itemId == R.id.menu_finished) {
                openFinishedList()

            }
            else if (menuItem.itemId== R.id.menu_search) {
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

    private fun openFinishedList() {
        //val editText = findViewById<EditText>(R.id.editText)
        //val message = editText.text.toString()
        val intent = Intent(this, FinishedActivity::class.java)
        startActivity(intent)
    }


    private fun initRecyclerView() {
        Thread {

            //Get the todoList
            val itemList = AppDatabase.getInstance(this@ToReadActivity).bookDAO().findAllItems()

            itemAdapter = BookAdapter(this@ToReadActivity, itemList)

            runOnUiThread {
                //Added

                recyclerToRead.adapter = itemAdapter //This line need to be in the tread because if it is outside, it is possible
                //that the this line is executed before the thread. Because thread is happening parallel

                val callback = BookTouchHelperCallback(itemAdapter)
                val touchHelper = ItemTouchHelper(callback)
                touchHelper.attachToRecyclerView(recyclerToRead)
            }

        }.start()
    }

    public fun showEditItemDialog(itemToEdit: Book, idx: Int) { //idx: 0,1,2,3... depends on which item we edit
        editIndex = idx
        val editItemDialog = DialogueToRead()

        val bundle = Bundle()

        bundle.putSerializable(KEY_ITEM_TO_EDIT, itemToEdit)
        editItemDialog.arguments = bundle

        editItemDialog.show(supportFragmentManager,
            "EDITITEMDIALOG")

    }


    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_add_toread, menu);
        return true;
    }


    private fun showItem() {
        DialogueToRead().show(supportFragmentManager, "TAG_CREATE")
        //initSpinner()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.itemId

        //Add a new item to the shopping list
        if (id == R.id.action_add) {
            showItem()
            return true;
        }
        else if (id == R.id.action_deleteAll) {
            deleteAll()

            return true;
        }
        else if (id == R.id.show_to_read_state) {
            return true;
        }
        return super.onOptionsItemSelected(item);


    }



    override fun itemCreated(item: Book) {
        //Everytime we need to access the database, we need to do this.
        Thread { //Added

            val id = AppDatabase.getInstance(this).bookDAO().insertItem(item)  //Access the database
            item.itemID = id

            //We can't change UI from another thread, so we need to specify that it is run on the same thread
            runOnUiThread{
                itemAdapter.addItem(item)
            }
        }.start()

    }

    //Update the database (instead of inserting doto into database
     override fun itemUpdated(item: Book) {
        val dbThread = Thread {

            AppDatabase.getInstance(this@ToReadActivity).bookDAO().updateItem(item)

            runOnUiThread { itemAdapter.updateToBuy(item, editIndex) }
        }
        dbThread.start()

    }

    fun deleteAll() {
        Thread {
            AppDatabase.getInstance(this@ToReadActivity).bookDAO().deleteAll()
            runOnUiThread {
                itemAdapter.deleteAll()
            }
        }.start()
    }

}
