package com.example.recyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list= ArrayList()

        var layout:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layout

        list.add(Model(R.drawable.a,"Laptop 1"))
        list.add(Model(R.drawable.abc,"Laptop 2"))
        list.add(Model(R.drawable.photo,"Laptop 3"))

        var myAdapter =MyAdapter(applicationContext,list)
        binding.recycler.adapter = myAdapter





    }
}