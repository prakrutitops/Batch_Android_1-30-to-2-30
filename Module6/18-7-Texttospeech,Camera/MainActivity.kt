package com.example.controlsex

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import org.intellij.lang.annotations.Language
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var btn1:Button
    lateinit var img:ImageView
    lateinit var btn2:Button
    lateinit var edt1:EditText
    lateinit var tts:TextToSpeech

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        img = findViewById(R.id.img)
        btn2 = findViewById(R.id.btn2)
        edt1 = findViewById(R.id.edt1)
        tts = TextToSpeech(applicationContext,this)

        btn1.setOnClickListener {

            var i = Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,1)
        }

        btn2.setOnClickListener {

            var data = edt1.text.toString()

            tts.speak(data,TextToSpeech.QUEUE_ADD,null)


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if(requestCode==1 && resultCode== RESULT_OK)
        {
            var bm:Bitmap = data!!.extras!!.get("data") as Bitmap
            img.setImageBitmap(bm)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onInit(status: Int)
    {

        tts.setLanguage(Locale.US)
        tts.setPitch(0.8F)
        tts.setSpeechRate(0.5F)


    }
}