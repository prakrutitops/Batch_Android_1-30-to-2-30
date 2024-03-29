package com.example.test

import com.example.mananproject.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface
{
    @FormUrlEncoded
    @POST("user_signup.php")
    fun registerdetail(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("gender") gender:String?,
        @Field("email") email: String?,
        @Field("phone") mobile: String?,
        @Field("password") password: String?,
        ): Call<Void>


    @FormUrlEncoded
    @POST("user_login.php")
    fun logindata(
        @Field("phone") mobile: String?,
        @Field("password") password: String?
    ): Call<RegisterModel>





}