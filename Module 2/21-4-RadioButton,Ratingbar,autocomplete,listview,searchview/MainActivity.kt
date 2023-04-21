package com.example.radiobuttonex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RatingBar
import android.widget.Toast

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener,
    RatingBar.OnRatingBarChangeListener {
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton
    lateinit var rating1:RatingBar
    lateinit var auto1:AutoCompleteTextView
    var city = arrayOf("baroda","surat","rajkot")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rating1 = findViewById(R.id.rate1)

        rb1.setOnCheckedChangeListener(this)
        rb2.setOnCheckedChangeListener(this)
        rating1.setOnRatingBarChangeListener(this)
        auto1 = findViewById(R.id.auto1)

        var adapter = ArrayAdapter(this,android.R.layout.select_dialog_item,city)
        auto1.threshold=2
        auto1.setAdapter(adapter)

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

            if(rb1.isChecked)
            {
                Toast.makeText(applicationContext,"Male",Toast.LENGTH_LONG).show()
            }
            if(rb2.isChecked)
            {
                Toast.makeText(applicationContext,"Female",Toast.LENGTH_LONG).show()
            }


    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean)
    {
        var myrate = ratingBar!!.rating
        Toast.makeText(applicationContext,""+myrate,Toast.LENGTH_LONG).show()
    }
}