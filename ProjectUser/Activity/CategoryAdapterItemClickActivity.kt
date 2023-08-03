package com.example.mananproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mananproject.R
import com.example.mananproject.databinding.ActivityCategoryAdapterItemClickBinding
import com.example.mananproject.databinding.ActivityCategoryBinding
import com.example.test.ApiClient
import com.example.test.ApiInterface
import com.squareup.picasso.Picasso

class CategoryAdapterItemClickActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryAdapterItemClickBinding
    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryAdapterItemClickBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        val intent = intent
        val image = intent.getStringExtra("image")
        val giftName = intent.getStringExtra("name")
        val giftDesc = intent.getStringExtra("desc")
        val giftPrice = intent.getStringExtra("price")

        Picasso.get().load(image).into(binding.photoView)
        binding.giftName.text = giftName
        binding.giftDesc.text = giftDesc
        binding.giftPrice.text = giftPrice

    }
}