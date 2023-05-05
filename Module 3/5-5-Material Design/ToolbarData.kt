package com.example.menusex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class ToolbarData : AppCompatActivity(), View.OnClickListener {
    lateinit var toolbar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_data)

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        toolbar.setLogo(R.mipmap.ic_launcher)
        toolbar.setSubtitle("last seen")
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)

        toolbar.setNavigationOnClickListener(this)

    }

    override fun onClick(v: View?)
    {
        Toast.makeText(applicationContext,"Back Button Pressed",Toast.LENGTH_LONG).show()
    }
}