package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var relativeLayout: RelativeLayout
    lateinit var txt1:TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.relative)

        Toast.makeText(applicationContext,"Created",Toast.LENGTH_LONG).show()

        relativeLayout = RelativeLayout(this)
        txt1 = TextView(this)
        txt1.setText("Hello")

        var width=100
        var height=100

        relativeLayout.addView(txt1,width, height)

        setContentView(relativeLayout)

    }

    override fun onStart()
    {
        super.onStart()
        Toast.makeText(applicationContext,"Started",Toast.LENGTH_LONG).show()

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext,"Restarated",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"Resume",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"Pause",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"Stopped",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"Destroy",Toast.LENGTH_LONG).show()
    }
}