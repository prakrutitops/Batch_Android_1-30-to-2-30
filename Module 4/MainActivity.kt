package com.example.sqliteex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqliteex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DbHelper(applicationContext)

        binding.btn1.setOnClickListener {

            var name = binding.edt1.text.toString()
            var num = binding.edt2.text.toString()

            var m = Model()
            m.name=name
            m.num=num

           var id = dbHelper.savedata(m)

            Toast.makeText(applicationContext,"Inserted "+id,Toast.LENGTH_LONG).show()
        }
        binding.btn2.setOnClickListener {

                startActivity(Intent(applicationContext,MainActivity2::class.java))



        }
    }
}