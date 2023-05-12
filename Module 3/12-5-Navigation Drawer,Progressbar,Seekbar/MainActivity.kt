package com.example.uicontrolsex

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var pb:ProgressBar
    lateinit var seek1:SeekBar
    lateinit var seek2:SeekBar
    lateinit var seek3:SeekBar
    lateinit var img:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        pb = findViewById(R.id.pb)

        seek1 = findViewById(R.id.seek1)
        seek2 = findViewById(R.id.seek2)
        seek3 = findViewById(R.id.seek3)
        img = findViewById(R.id.img)

        seek1.setOnSeekBarChangeListener(this)
        seek2.setOnSeekBarChangeListener(this)
        seek3.setOnSeekBarChangeListener(this)



        btn1.setOnClickListener {

            pb.incrementProgressBy(1)
            setProgress(100*pb.progress)


        }
        btn2.setOnClickListener {

            pb.incrementProgressBy(-1)
            setProgress(100*pb.progress)
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        var r = seek1.progress
        var g = seek2.progress
        var b = seek3.progress

        img.setBackgroundColor(Color.rgb(r,g,b))
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}