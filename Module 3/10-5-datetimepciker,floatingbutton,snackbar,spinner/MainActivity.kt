package com.example.dateandtimepickerexample

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var spin:Spinner
    lateinit var f1:FloatingActionButton

    var data = arrayOf("Ahmedabad","Rajkot","Surat")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        spin = findViewById(R.id.spin)
        f1 = findViewById(R.id.f1)

        btn1.setOnClickListener {

            var d = MyDatePicker()
            d.show(supportFragmentManager,"DATE")

        }
        btn2.setOnClickListener {

            var d = MyTimePicker()
            d.show(supportFragmentManager,"TIME")
        }

        spin.setOnItemSelectedListener(this)

        f1.setOnClickListener {

            Snackbar.make(it,"Floating Called",Snackbar.LENGTH_LONG).show()

        }

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,data)
        spin.adapter=adapter
    }
    class MyDatePicker :DialogFragment(), DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
        {
            var c = Calendar.getInstance()
            var date = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)
            return DatePickerDialog(requireActivity(),this,year,month,date)
        }

        override fun onDateSet(view: android.widget.DatePicker?, year: Int, month: Int, dayOfMonth: Int)
        {
           Toast.makeText(requireActivity(),""+dayOfMonth+"-"+month+"-"+year,Toast.LENGTH_LONG).show()
        }
    }
    class MyTimePicker :DialogFragment(), TimePickerDialog.OnTimeSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
        {
            var c = Calendar.getInstance()
            var hour = c.get(Calendar.HOUR_OF_DAY)
            var minute = c.get(Calendar.MINUTE)


            return TimePickerDialog(requireActivity(),this,hour,minute,false)
        }


        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int)
        {
            Toast.makeText(requireActivity(),""+hourOfDay+":"+minute,Toast.LENGTH_LONG).show()
        }
    }



    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
    {

        Toast.makeText(applicationContext,""+data[position],Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?)
    {

    }
}