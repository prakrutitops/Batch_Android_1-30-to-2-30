package com.example.profilea

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import de.hdodenhof.circleimageview.CircleImageView
import net.gotev.uploadservice.MultipartUploadRequest
import net.gotev.uploadservice.UploadNotificationConfig
import java.io.IOException
import java.util.*

class RegistrationActivity : AppCompatActivity() {
    var edtname: EditText? = null
    var edtemail: EditText? = null
    var edtpass: EditText? = null
    var btnregi: Button? = null
    var pd: ProgressDialog? = null
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var passPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
    var UPLOAD_URL = "https://vyasprakruti.000webhostapp.com/db_files/animal/image_upload.php"
    lateinit var imageView: CircleImageView

    //Image request code
    private val PICK_IMAGE_REQUEST = 1

    //Bitmap to get image from gallery
    private var bitmap: Bitmap? = null

    //Uri to store the image uri
    private var filePath: Uri? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        requestStoragePermission()

        //Initializing views
        imageView = findViewById(R.id.imageView)
        edtname = findViewById<EditText>(R.id.reg_name)
        edtemail = findViewById<EditText>(R.id.reg_email)
        edtpass = findViewById<EditText>(R.id.reg_pass)
        btnregi = findViewById<Button>(R.id.btn_regi)
        pd = ProgressDialog(this)
        pd!!.setMessage("Please Wait...")
        //imageView.setOnClickListener { showFileChooser() }
        imageView.setOnClickListener {
            showFileChooser()
        }
        btnregi!!.setOnClickListener { uploadMultipart() }
    }

    private fun uploadMultipart() {
        pd!!.show()
        val name: String = edtname!!.getText().toString().trim { it <= ' ' }
        val email: String = edtemail!!.getText().toString().trim { it <= ' ' }
        val pass: String = edtpass!!.getText().toString().trim { it <= ' ' }
        val path = getPath(filePath)
        try {
            if (name == "") {
                pd!!.hide()
                edtname!!.setError("Enter Name.!")
            } else if (email == "") {
                pd!!.hide()
                edtemail!!.setError("Enter Email.!")
            } else if (pass == "") {
                pd!!.hide()
                edtpass!!.setError("Enter Password.!")
            } /*else if (email.matches(emailPattern) == false) {
                pd!!.hide()
                edtemail!!.setError("Invalid Email.!")
            } else if (pass.matches(passPattern) == false) {
                pd!!.hide()
                edtpass!!.setError("A-Z,a-z,0-9,$*%@")
            }*/ else {
                pd!!.hide()
                val uploadId = UUID.randomUUID().toString()

                //Creating a multi part request
                MultipartUploadRequest(this, uploadId, UPLOAD_URL)
                    .addFileToUpload(path, "img") //Adding file
                    .addParameter("name", name) //Adding text parameter to the request
                    .addParameter("email", email)
                    .addParameter("password", pass)
                    //.setNotificationConfig(UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload() //Starting the upload
                Toast.makeText(this, "Registration successfully", Toast.LENGTH_SHORT).show()
                val i = Intent(this@RegistrationActivity, LoginActivity::class.java)
                startActivity(i)
            }
        } catch (exc: Exception) {
            Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("Range")
    private fun getPath(uri: Uri?): String {
        var cursor: Cursor = getContentResolver().query(uri!!, null, null, null, null)!!
        cursor.moveToFirst()
        var document_id = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = getContentResolver().query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf<String>(document_id), null
        )!!
        cursor.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }

    private fun showFileChooser() {
        val intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    protected override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData()
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath)
                imageView!!.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        ) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(
            this,
            arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE),
            STORAGE_PERMISSION_CODE
        )
    }

    companion object {
        //storage permission code
        private const val STORAGE_PERMISSION_CODE = 123
    }
}