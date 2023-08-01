package com.example.mananproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mananproject.Model.RegisterModel
import com.example.mananproject.R
import com.example.mananproject.databinding.ActivityLoginBinding
import com.example.test.ApiClient
import com.example.test.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    private lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,SignupActivity::class.java))
        }
        binding.btnLogIn.setOnClickListener {


            val phone = binding.edtPhone.text.toString()
            val pass = binding.edtPassword.text.toString()

            apiinterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)
            val call: Call<RegisterModel> = apiinterface.logindata(phone,pass)
            call.enqueue(object: Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>, )
                {

                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                    //startActivity(Intent(applicationContext, DashboardActivity::class.java))

                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()

                }
            })
        }
    }
}