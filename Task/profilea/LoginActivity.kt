package com.example.profilea

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {
    var btnlogin: Button? = null
    var txtreg: TextView? = null
    var edtemail: EditText? = null
    var edtpass: EditText? = null
    var url = "https://vyasprakruti.000webhostapp.com/db_files/animal/new_login.php"
    var pd: ProgressDialog? = null
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var passPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
    var m: Mode = Mode()
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("user_session", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("session", false) &&
            !sharedPreferences.getString("email", "")!!.isEmpty() &&
            !sharedPreferences.getString("pic", "")!!.isEmpty()
        ) {
            startActivity(Intent(this@LoginActivity, AnimalActivity::class.java))
            finish()
        }
        btnlogin = findViewById<Button>(R.id.btn_login)
        txtreg = findViewById<TextView>(R.id.txtregi)
        edtemail = findViewById<EditText>(R.id.et_email)
        edtpass = findViewById<EditText>(R.id.et_pass)
        pd = ProgressDialog(this)
        pd!!.setMessage("Authenticating...")
        btnlogin!!.setOnClickListener {
            pd!!.show()
            val stringRequest: StringRequest = object : StringRequest(Request.Method.POST, url, object : Response.Listener<String>{
                    override fun onResponse(response: String) {
                        if (edtemail!!.getText().toString().isEmpty()) {
                            pd!!.hide()
                            edtemail!!.setError("Enter Email.!")
                        }/* else if (edtemail!!.getText().toString().trim { it <= ' ' }
                                .matches(emailPattern) == false) {
                            pd.hide()
                            edtemail.setError("Enter Proper Email.!")
                        } else if (edtpass.getText().toString().trim { it <= ' ' }
                                .matches(passPattern) == false) {
                            edtpass.setError("Enter Password.!")
                        } */else if (response.trim { it <= ' ' } == "0") {
                            pd!!.hide()
                            Toast.makeText(
                                getApplicationContext(),
                                "Login Failed",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            pd!!.hide()
                            Toast.makeText(
                                getApplicationContext(),
                                "Login Success",
                                Toast.LENGTH_LONG
                            ).show()
                            try {
                                val `object` = JSONObject(response)
                                val array: JSONArray = `object`.getJSONArray("result")
                                for (i in 0 until array.length()) {
                                    val obj: JSONObject = array.getJSONObject(i)
                                    val id: Int = obj.getInt("id")
                                    val name: String = obj.getString("name")
                                    val email: String = obj.getString("email")
                                    val pass: String = obj.getString("password")
                                    val img: String = obj.getString("img")
                                    //Mode set data from url online
                                    m.name = name
                                    m.password = pass
                                    m.email = email
                                    m.img = img
                                    m.id = id
                                    //Toast.makeText(getApplicationContext(), ""+m.getImg(), Toast.LENGTH_LONG).show();
                                    val i1 = Intent(this@LoginActivity, AnimalActivity::class.java)
                                    sharedPreferences.edit().putString("email", m.email)
                                        .commit()
                                    sharedPreferences.edit().putString("pic", m.img).commit()
                                    sharedPreferences.edit().putBoolean("session", true).commit()
                                    startActivity(i1)
                                }
                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                        }
                    }
                }, object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {
                        pd!!.hide()
                        Toast.makeText(this@LoginActivity, "No Internet", Toast.LENGTH_SHORT).show()
                    }
                }) {
                override fun getParams(): MutableMap<String, String>?
                {
                    val map: MutableMap<String, String> = HashMap()
                    map["email"] = edtemail!!.getText().toString()
                    map["password"] = edtpass!!.getText().toString()
                    return map
                }

                }
            val rq: RequestQueue = Volley.newRequestQueue(this@LoginActivity)
            rq.add(stringRequest)
        }
        txtreg!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(i)
        })
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}