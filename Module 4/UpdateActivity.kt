package com.example.sqliteex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqliteex.databinding.ActivityMain2Binding
import com.example.sqliteex.databinding.ActivityMainBinding
import com.example.sqliteex.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DbHelper(applicationContext)
        var i = intent
        var id = i.getIntExtra("id",101)
        var name = i.getStringExtra("name")
        var num = i.getStringExtra("number")

        binding.edt1.setText(name)
        binding.edt2.setText(num)

        binding.btn1.setOnClickListener {


            var name = binding.edt1.text.toString()
            var num = binding.edt2.text.toString()



            var m = Model()
            m.id=id
            m.name=name
            m.num=num

            var id = dbHelper.updatedata(m)

            Toast.makeText(applicationContext,"Updated ", Toast.LENGTH_LONG).show()
            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }

    }
}