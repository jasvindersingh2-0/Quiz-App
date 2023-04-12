package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val user_name=intent.getStringExtra(Constants.USER_NAME)
        tv_username.text=user_name
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tv_score.text="Your Score is $correctAnswers out of $totalQuestions"
        btn_finish.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}