package com.example.firebasecrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasecrud.databinding.ActivityMain2Binding
import com.example.firebasecrud.databinding.ActivityMainBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var myAdapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        FirebaseApp.initializeApp(applicationContext)
        setContentView(view)

        val rl: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = rl

        val options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("tops"), Model::class.java)
            .build()

        myAdapter = MyAdapter(options)
        binding.recycler.adapter =myAdapter


    }
    override fun onStart() {
        super.onStart()
        myAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        myAdapter.stopListening()
    }

    override fun onRestart() {
        super.onRestart()
        myAdapter.startListening()
    }

    override fun onResume() {
        super.onResume()
        myAdapter.startListening()
    }
    override fun onPause() {
        super.onPause()
        myAdapter.stopListening()
    }

}