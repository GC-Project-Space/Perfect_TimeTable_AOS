package com.example.perfecttimetable

import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.perfecttimetable.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivitySettingBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //sharedPreferences
        sharedPreferences = getSharedPreferences("setting", MODE_PRIVATE)

        //클릭 리스너 등록
        binding.monTxt.setOnClickListener(this)
        binding.tusTxt.setOnClickListener(this)
        binding.wenTxt.setOnClickListener(this)
        binding.thuTxt.setOnClickListener(this)
        binding.friTxt.setOnClickListener(this)

        binding.grade1Txt.setOnClickListener(this)
        binding.grade2Txt.setOnClickListener(this)
        binding.grade3Txt.setOnClickListener(this)
        binding.grade4Txt.setOnClickListener(this)

        binding.time1Txt.setOnClickListener(this)
        binding.time2Txt.setOnClickListener(this)
        binding.time3Txt.setOnClickListener(this)
        binding.time4Txt.setOnClickListener(this)
    }

    override fun onClick(v:View){
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        when(v.id){
            binding.monTxt.id -> {
                allDayColorBlack()
                editor.putString("selected_day", Constance.MONDAY)
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.tusTxt.id ->{
                allDayColorBlack()
                editor.putString("selected_day", Constance.TUESDAY)
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.wenTxt.id -> {
                allDayColorBlack()
                editor.putString("selected_day", Constance.WEDNESDAY)
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.thuTxt.id -> {
                allDayColorBlack()
                editor.putString("selected_day", Constance.THURSDAY)
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.friTxt.id -> {
                allDayColorBlack()
                editor.putString("selected_day", Constance.FRIDAY)
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time1Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_time", "1")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time2Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_time", "2")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time3Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_time", "3")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time4Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_time", "4")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade1Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_grade", "1")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade2Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_grade", "2")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade3Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_grade", "3")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade4Txt.id -> {
                allDayColorBlack()
                editor.putString("selected_grade", "4")
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }

        }

    }

    //textView 색 검정으로 초기화
    private fun allDayColorBlack(){
        binding.monTxt.setTextColor(Color.parseColor("#000000"))
        binding.tusTxt.setTextColor(Color.parseColor("#000000"))
        binding.wenTxt.setTextColor(Color.parseColor("#000000"))
        binding.thuTxt.setTextColor(Color.parseColor("#000000"))
        binding.friTxt.setTextColor(Color.parseColor("#000000"))
    }

    private fun allTimeColorBlack(){
        binding.time1Txt.setTextColor(Color.parseColor("#000000"))
        binding.time2Txt.setTextColor(Color.parseColor("#000000"))
        binding.time3Txt.setTextColor(Color.parseColor("#000000"))
        binding.time4Txt.setTextColor(Color.parseColor("#000000"))
    }
    private fun allGradeColorBlack(){
        binding.grade1Txt.setTextColor(Color.parseColor("#000000"))
        binding.grade2Txt.setTextColor(Color.parseColor("#000000"))
        binding.grade3Txt.setTextColor(Color.parseColor("#000000"))
        binding.grade4Txt.setTextColor(Color.parseColor("#000000"))

    }
}