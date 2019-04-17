package com.example.etta.booktracker.dialogues

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.widget.*
import com.example.etta.booktracker.R
import com.example.etta.booktracker.ToReadActivity
import com.example.etta.booktracker.data.Book
import kotlinx.android.synthetic.main.dialogue_to_read.view.*
import java.lang.RuntimeException

class DialogueToRead : DialogFragment() {

    interface ItemHandler {
        fun itemCreated(item: Book)

        fun itemUpdated(item:Book)

    }


    //Make us be able to send text from the dialog
    private lateinit var itemHandler: ItemHandler

    //@param context: the context which opens dialog
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is ItemHandler) {
            itemHandler = context
        } else {
            throw RuntimeException("The activity does not implement the ItemHandlerInterface")
        }
    }

    private lateinit var etName: EditText
    private lateinit var etAuthor: EditText
    private lateinit var etISBN: EditText
    private lateinit var etLanguage: EditText
    private lateinit var etSubject: EditText
   // private lateinit var cbDone: CheckBox
    private lateinit var spinner: Spinner


    var spinnerCategory = arrayOf("one star","two stars","three stars","four stars", "five stars")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle(getString(R.string.str_ntr))

        //Inflate the dialog and the xml
        val rootView = requireActivity().layoutInflater.inflate(R.layout.dialogue_to_read, null)


        //Same as the next line: etTodoText = rootView.findViewById(R.id.etTodoText).
        //It finds the edit text in the view and assign is to the private edTodoDate
        etName = rootView.etTitle
        etAuthor = rootView.etAuthor
        //cbDone=rootView.etISBN_13
        spinner=rootView.et_desire
        etISBN=rootView.etISBN_13
        etLanguage=rootView.etLanguage
        etSubject= rootView.etSubject

        //initSpinner(spinner)

        spinner.adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, spinnerCategory)

        builder.setView(rootView)


        val arguments = this.arguments
        if (arguments != null && arguments.containsKey(ToReadActivity.KEY_ITEM_TO_EDIT)) {
            val toReadBook = arguments.getSerializable(
                ToReadActivity.KEY_ITEM_TO_EDIT  //KeyItem_To_Edit defined in the scrolling view
            ) as Book
            etName.setText(toReadBook.bookName)
            etAuthor.setText(toReadBook.author)
            spinner.setSelection(toReadBook.desire)
            etISBN.setText(toReadBook.isbn)
            etSubject.setText(toReadBook.subject)
            etLanguage.setText(toReadBook.language)
            //cbDone.isChecked=toReadBook.done

            //val valueOfSelectedPos = rootView.category.getSelectedItem().toString()

            builder.setTitle(getString(R.string.str_ed))
        } else {


        }

        //just set to avoid a well-known bug
        builder.setPositiveButton("Add Book") {
                dialog, which ->  //always empty
        }

        //just set to avoid a well-known bug
        builder.setNegativeButton("Cancel") {
                dialog, which ->  //always empty
        }

        return builder.create()

    }

    override fun onResume() {
        super.onResume()

        val positiveButton = (dialog as AlertDialog).getButton(Dialog.BUTTON_POSITIVE)
        positiveButton.setOnClickListener {

            //If the doto text is not empty
            if (etName.text.isNotEmpty()) {
                if( etAuthor.text.isNotEmpty()) {
                    if (spinner.selectedItem != null) {


                        //Check if we are in the right mode
                        val arguments = this.arguments

                        //If we are in the create mode, we handle todoEdit
                        if (arguments != null && arguments.containsKey(ToReadActivity.KEY_ITEM_TO_EDIT)) {
                            handleItemEdit()
                        } else {
                            handleItemCreate()
                        }

                        dialog.dismiss()
                    }

                    else {
                        //spinner can not be empty
                    }
                }else {
                    etAuthor.error= getString(R.string.str_empty)

                }
            } else {
                etName.error = getString(R.string.str_empty)
            }
        }
    }


    /**
     * Create a new
     */
    private fun handleItemCreate() {
        //Create a new create object and get it from the edittext
        itemHandler.itemCreated(
             Book(
                null,
                etName.text.toString(),
                 etAuthor.text.toString(),
                false,
                 etLanguage.text.toString(),
                 spinner.selectedItemPosition,
                 etSubject.text.toString(),

                etISBN.text.toString(),
                 null,
                 null,
                 null
            )
        )
    }

    private fun handleItemEdit() {
        val itemToEdit = arguments?.getSerializable(
            ToReadActivity.KEY_ITEM_TO_EDIT
        ) as Book
        itemToEdit.bookName = etName.text.toString()
        itemToEdit.author = etAuthor.text.toString()
        itemToEdit.desire = spinner.selectedItemPosition
        //itemToEdit.done = cbDone.isChecked
        itemToEdit.isbn=etISBN.text.toString()
        itemToEdit.language=etLanguage.text.toString()


        //Send back to the activity
        itemHandler.itemUpdated(itemToEdit)
    }







}
