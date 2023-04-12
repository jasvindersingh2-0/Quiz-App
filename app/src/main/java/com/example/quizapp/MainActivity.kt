package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_start.setOnClickListener {
            if(et_Name.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else{
                var intent=Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,et_Name.text.toString())
                startActivity(intent)
                finish() // By this we can't come back to previous page
            }
        }

    }
}