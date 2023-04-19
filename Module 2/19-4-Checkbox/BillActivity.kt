package com.example.uicontrols

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class BillActivity : AppCompatActivity()
{
    lateinit var txt1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        txt1= findViewById(R.id.txt1)

        var i = intent
        var data = i.getStringExtra("Bill")
        txt1.setText(data)
    }

    override fun onBackPressed()
    {
        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        })
        alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()
        })
        alert.show()
    }
}