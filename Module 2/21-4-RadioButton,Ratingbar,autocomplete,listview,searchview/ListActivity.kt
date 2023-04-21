package com.example.radiobuttonex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener

class ListActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<String>
    lateinit var searchView: SearchView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView = findViewById(R.id.list)
        list = ArrayList()
        searchView = findViewById(R.id.search)

        list.add("Android")
        list.add("Java")
        list.add("Php")

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listView.adapter =adapter

        searchView.setOnQueryTextListener(object :OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean
            {
               /* if(list.contains(query))
                {
                    adapter.filter.filter(query)
                }*/
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean
            {
                adapter.filter.filter(newText)

                return  true
            }
        })



    }
}