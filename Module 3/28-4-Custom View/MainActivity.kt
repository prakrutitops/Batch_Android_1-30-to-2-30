package com.example.customtoastdialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.customtoastdialog.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{


    private lateinit var binding: ActivityMainBinding
    var map = HashMap<String,Int>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        map.put("Hannibal",R.drawable.internet)
        map.put("Big Bang Theory",R.drawable.a)
        map.put("House of Cards",R.drawable.internet)
        map.put("Game of Thrones", R.drawable.a)

        for (name in map.keys)
        {
            val textSliderView = TextSliderView(this)
            // initialize a SliderLayout
            textSliderView
                .description(name)
                .image(map.get(name)!!)


            //add your extra information
           // textSliderView.bundle(Bundle())extSliderView.bundle .putString("extra", name)
            binding.slider.addSlider(textSliderView)
        }
        binding.btn1.setOnClickListener {

            var toast = Toast(this)
            var layout= LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design,null)
            toast.view=view
            toast.setGravity(Gravity.CENTER,0,0)
            toast.duration=Toast.LENGTH_LONG
            toast.show()



        }
        binding.btn2.setOnClickListener {

            var alertdialog = AlertDialog.Builder(this)
            var layout= LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design,null)
            alertdialog.setView(view)
            alertdialog.show()


        }


    }
}