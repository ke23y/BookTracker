package com.example.etta.booktracker

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btnSearch.setOnClickListener {
            val intentSearch = Intent(Intent.ACTION_WEB_SEARCH)
            intentSearch.putExtra(SearchManager.QUERY, tvQuery.text.toString())
            startActivity(intentSearch)
        }

    }




}
