package com.example.quizapp

data class Questions(
    val id: Int,
    val Question: String,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val image:Int,
    val correctAnswer:Int
    )