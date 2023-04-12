package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition=1
    private var mQuestionList: ArrayList<Questions>?=null
    private var mSelectedOption:Int=0
    private var mCorrectAnswer:Int=0
    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
        mQuestionList=Constants.getQuestions()
        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }
    private fun setQuestion(){
        val question = mQuestionList!![mCurrentPosition-1]
        defaultOptionViews()
        if(mSelectedOption==mQuestionList!!.size){
            btn_submit.text="Finish"
        }else{ btn_submit.text="Submit"}
        progressBar.progress=mCurrentPosition
        tv_ProgressBar.text="$mCurrentPosition"+"/"+progressBar.max
        tv_question_text.text=question!!.Question
        iv_image.setImageResource(question.image)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
    }
    private fun defaultOptionViews(){
        val options= arrayListOf<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one->{
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three->{
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit->{
                if(mSelectedOption==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }else->{
                            val intent=Intent(this,FinishActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                        startActivity(intent)
                        finish()
                        }
                    }
                }
                else{
                    val question= mQuestionList!![mCurrentPosition-1]
                    if(question.correctAnswer!=mSelectedOption){
                        answerView(mSelectedOption,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestionList!!.size){
                        btn_submit.text="Finish"
                    }
                    else{
                        btn_submit.text="Go to Next Question"
                    }
                }

                mSelectedOption=0

            }
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionViews()
        mSelectedOption=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface= Typeface.DEFAULT_BOLD
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tv_option_one.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tv_option_two.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
            tv_option_three.background=ContextCompat.getDrawable(this,drawableView)
        }
            4->{
            tv_option_four.background=ContextCompat.getDrawable(this,drawableView)
        }
        }

    }
}