package com.example.jsoncrudex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class UpdateActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)

        btn1 = findViewById(R.id.btn1)

        var i = intent
        var id = i.getStringExtra("id")
        edt1.setText(i.getStringExtra("name"))
        edt2.setText(i.getStringExtra("price"))

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var price = edt2.text.toString()


            var stringrequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productupdate.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"UPDATED",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,ViewActivity::class.java))

                },Response.ErrorListener {

                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()


                })
            {
                override fun getParams(): MutableMap<String, String>?
                {

                    var map = HashMap<String,String>()
                    map["product_id"]=id.toString()
                    map["product_name"]=name
                    map["product_price"]=price


                    return map
                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)
        }


    }
}