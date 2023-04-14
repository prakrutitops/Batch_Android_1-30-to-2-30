package com.example.formexample1

import android.Manifest.permission.*
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE ),101)
        }
        if(checkSelfPermission(CAMERA)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CAMERA),101)
        }


        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var pass = edt2.text.toString()

            if(name.length==0 && pass.length==0)
            {
                edt1.setError("Please Enter Name")
                edt2.setError("Please Enter Password")
            }
            else if(name.length==0)
            {
                edt1.setError("Please Enter Name")
            }
            else if(pass.length==0)
            {
                edt2.setError("Please Enter Password")
            }
            else
            {
                if(name.equals("tops") && pass.equals("1234"))
                {
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                    var i = Intent(applicationContext,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            }





        }

    }

    override fun onBackPressed()
    {
        finishAffinity()
    }

}