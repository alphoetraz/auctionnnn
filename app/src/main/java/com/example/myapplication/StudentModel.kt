package com.example.myapplication

import kotlin.random.Random

data class StudentModel(
    var id: Int = getAutoId(),
    var productname: String = "",
    var productprice: String = "",
    var productexplanation: String = ""

    ){

    companion object{

    fun getAutoId():Int{
        val random = Random
        return random.nextInt(100)

    }
    }

}
