package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var stdList: ArrayList<StudentModel> = ArrayList()

    fun addItems(items:ArrayList<StudentModel>){
        this.stdList = items
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StudentViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_items_std,parent,false)

    )



    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        val std = stdList[position]
        holder.bindView(std)
    }

    override fun getItemCount(): Int {
        return stdList.size

    }





    class StudentViewHolder(var view: View): RecyclerView.ViewHolder(view){
        private var id = view.findViewById<TextView>(R.id.tvId)
        private var productname = view.findViewById<TextView>(R.id.tvName)
        private var productprice = view.findViewById<TextView>(R.id.tvPrice)
        private var productexplanation = view.findViewById<TextView>(R.id.tvExplanation)
        private var btnDelete = view.findViewById<Button>(R.id.btnDelete)

        fun bindView(std:StudentModel){
            id.text = std.id.toString()
            productname.text = std.productname
            productprice.text = std.productprice
            productexplanation.text = std.productexplanation

        }


    }

}