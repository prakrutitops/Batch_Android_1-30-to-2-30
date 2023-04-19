package com.example.uicontrols

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class DashboardActivity : AppCompatActivity()
{
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btnorder)

        btn1.setOnClickListener {


                var amount =0
                var item:StringBuffer = StringBuffer("\n selected Item: ")
                if(chk1.isChecked)
                {
                    amount+=100
                    item.append("\n Pizza @ Rs.100")
                }
                if(chk2.isChecked)
                {
                    amount+=50
                    item.append("\n Burger @ Rs.50")
                }
                if(chk3.isChecked)
                {
                    amount+=120
                    item.append("\n Coffee @ Rs.120")
                }

                    item.append("\n Total is: $amount")

                //Toast.makeText(applicationContext,""+item+total,Toast.LENGTH_LONG).show()
                var i = Intent(applicationContext,BillActivity::class.java)
                i.putExtra("Bill",item.toString())
                startActivity(i)

        }


    }

    override fun onBackPressed() {
        finishAffinity()
    }
}