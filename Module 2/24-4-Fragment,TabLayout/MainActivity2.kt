package com.example.fragmentex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity()
{
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

                var f1 = FirstFragment()
                var fm:FragmentManager = supportFragmentManager
                var ft:FragmentTransaction = fm.beginTransaction()
                ft.replace(R.id.frmid,f1).commit()


        }

    }
}