package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ListView

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.pizza,"Pizza","Spicy Pizza","250"))
        list.add(Model(R.drawable.burger,"Burger","New Burger","70"))
        list.add(Model(R.drawable.coffee,"Coffee","Hot Coffee","120"))
        list.add(Model(R.drawable.pizza,"Pizza","Spicy Pizza","250"))
        list.add(Model(R.drawable.burger,"Burger","New Burger","70"))
        list.add(Model(R.drawable.coffee,"Coffee","Hot Coffee","120"))
        list.add(Model(R.drawable.pizza,"Pizza","Spicy Pizza","250"))
        list.add(Model(R.drawable.burger,"Burger","New Burger","70"))
        list.add(Model(R.drawable.coffee,"Coffee","Hot Coffee","120"))
        list.add(Model(R.drawable.pizza,"Pizza","Spicy Pizza","250"))
        list.add(Model(R.drawable.burger,"Burger","New Burger","70"))
        list.add(Model(R.drawable.coffee,"Coffee","Hot Coffee","120"))

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter = adapter




    }
}