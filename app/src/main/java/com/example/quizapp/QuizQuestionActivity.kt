package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionBinding
    private var mCurrentPosition=1
    private var mQuestionList: ArrayList<Questions>?=null
    private var mSelectedOption:Int=0
    private var mCorrectAnswer:Int=0
    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityQuizQuestionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
        mQuestionList=Constants.getQuestions()
        setQuestion()
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

    }
    private fun setQuestion(){
        val question = mQuestionList!![mCurrentPosition-1]
        defaultOptionViews()
        if(mSelectedOption==mQuestionList!!.size){
            binding.btnSubmit.text="Finish"
        }else{ binding.btnSubmit.text="Submit"}
        binding.progressBar.progress=mCurrentPosition
        binding.tvProgressBar.text="$mCurrentPosition"+"/"+binding.progressBar.max
        binding.tvQuestionText.text=question!!.Question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text=question.optionOne
        binding.tvOptionTwo.text=question.optionTwo
        binding.tvOptionThree.text=question.optionThree
        binding.tvOptionFour.text=question.optionFour
    }
    private fun defaultOptionViews(){
        val options= arrayListOf<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one->{
                selectedOptionView(binding.tvOptionOne,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tv_option_three->{
                selectedOptionView(binding.tvOptionThree,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(binding.tvOptionFour,4)
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
                        binding.btnSubmit.text="Finish"
                    }
                    else{
                       binding.btnSubmit.text="Go to Next Question"
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
                binding.tvOptionOne.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                binding.tvOptionTwo.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
            binding.tvOptionThree.background=ContextCompat.getDrawable(this,drawableView)
        }
            4->{
            binding.tvOptionFour.background=ContextCompat.getDrawable(this,drawableView)
        }
        }

    }
}