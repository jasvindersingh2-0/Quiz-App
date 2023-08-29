package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityFinishBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val user_name=intent.getStringExtra(Constants.USER_NAME)
        binding.tvUsername.text=user_name
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        binding.tvScore.text="Your Score is $correctAnswers out of $totalQuestions"
        binding.btnFinish.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}