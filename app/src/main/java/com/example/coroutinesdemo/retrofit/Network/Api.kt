package com.example.coroutinesdemo.retrofit.Network


import com.example.coroutinesdemo.retrofit.Model.Post
import retrofit2.http.GET

interface Api
{
    @GET("posts")
    suspend fun getAllPost(): List<Post>
}