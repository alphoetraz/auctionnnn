package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class seeproduct : AppCompatActivity() {




    private lateinit var recyclerView:RecyclerView
    private var adapter: StudentAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seeproduct)


        initView()
        initRecyclerView()
    }







    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter()
        recyclerView.adapter = adapter
    }


    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
    }


}