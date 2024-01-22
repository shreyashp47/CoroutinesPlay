package com.example.coroutinesdemo.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesdemo.R
import com.example.coroutinesdemo.retrofit.Adapter.PostAdapter
import com.example.coroutinesdemo.retrofit.Model.Post
import com.example.coroutinesdemo.retrofit.Repository.PostRepository
import com.example.coroutinesdemo.retrofit.ViewModel.PostViewModel
import com.example.coroutinesdemo.retrofit.ViewModel.PostViewModelFactory

class RetrofitActivity : AppCompatActivity() {

    private lateinit var postRepository: PostRepository
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var postViewModel: PostViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private  lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retrofit_layout)

        initRecyclerView()

        postRepository= PostRepository()
        postViewModelFactory= PostViewModelFactory(postRepository)
        postViewModel= ViewModelProvider(this,postViewModelFactory).get(PostViewModel::class.java)

        postViewModel.getPost()

        postViewModel.myResponse.observe(this, Observer {
            postAdapter.setPostData(it as ArrayList<Post>)
            Log.d("main", it[0].title)
            progressBar.visibility= View.GONE
            recyclerView.visibility= View.VISIBLE
        })

    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        progressBar=findViewById(R.id.progressBar)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@RetrofitActivity)
            adapter=postAdapter
        }
    }
}