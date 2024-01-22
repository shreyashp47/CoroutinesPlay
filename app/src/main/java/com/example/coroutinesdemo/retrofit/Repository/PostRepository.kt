package com.example.coroutinesdemo.retrofit.Repository

import com.example.coroutinesdemo.retrofit.Model.Post
import com.example.coroutinesdemo.retrofit.Network.RetrofitBuilder

class PostRepository {

    suspend fun getPost(): List<Post> = RetrofitBuilder.api.getAllPost()

}