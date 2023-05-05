package com.example.menusex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    lateinit var listView: ListView
    lateinit var list: MutableList<String>
    lateinit var btn:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()
        btn = findViewById(R.id.btn1)

        list.add("A")
        list.add("B")
        list.add("C")
        list.add("D")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter = adapter

        registerForContextMenu(listView)

        btn.setOnClickListener {

                var pm:PopupMenu = PopupMenu(applicationContext,btn)
                pm.menuInflater.inflate(R.menu.popup,pm.menu)
                pm.setOnMenuItemClickListener(this)
                pm.show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"About us ",Toast.LENGTH_LONG).show()
            }
            R.id.i2->
            {
                Toast.makeText(applicationContext,"Contact us ",Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        when(item.itemId)
        {
            R.id.pos->
            {
                Toast.makeText(applicationContext,""+acm.position,Toast.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean
    {
        when(item!!.itemId)
        {
            R.id.movie->
            {
                Toast.makeText(applicationContext,"a",Toast.LENGTH_LONG).show()
            }
            R.id.movie2->
            {
                Toast.makeText(applicationContext,"b",Toast.LENGTH_LONG).show()
            }
            R.id.movie3->
            {
                Toast.makeText(applicationContext,"c",Toast.LENGTH_LONG).show()
            }
        }
        return false
    }
}