package com.example.retrofitcrudex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var apiinterface:Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtprice)
        btn1 = findViewById(R.id.btn1)

        var i = intent
        var pos = i.getStringExtra("position")
        var id = i.getIntExtra("id",101)
        var name = i.getStringExtra("name")
        var price = i.getStringExtra("price")
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        edt1.setText(name)
        edt2.setText(price)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var price = edt2.text.toString()



            var call: Call<Void> = apiinterface.updatedata(id.toString(),name,price)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(applicationContext,"Data Updated", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}