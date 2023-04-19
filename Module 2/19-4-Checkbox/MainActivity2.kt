package com.example.uicontrols

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var mob = edt1.text.toString()
            var pass = edt2.text.toString()

            if(mob.equals("8849817264") && pass.equals("1234"))
            {
                startActivity(Intent(applicationContext,DashboardActivity::class.java))
            }
            else
            {
                    Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
            }
        }

    }
    override fun onBackPressed() {
        finishAffinity()
    }
}