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

        setView()

        binding.closeBtn.setOnClickListener {
            finish()
        }

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
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.tusTxt.id ->{
                allDayColorBlack()
                editor.putString("selected_day", Constance.TUESDAY)
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.wenTxt.id -> {
                allDayColorBlack()
                editor.putString("selected_day", Constance.WEDNESDAY)
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.thuTxt.id -> {
                allDayColorBlack()
                editor.putString("selected_day", Constance.THURSDAY)
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.friTxt.id -> {
                allDayColorBlack()
                editor.putString("selected_day", Constance.FRIDAY)
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time1Txt.id -> {
                allTimeColorBlack()
                editor.putString("selected_time", "1")
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time2Txt.id -> {
                allTimeColorBlack()
                editor.putString("selected_time", "2")
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time3Txt.id -> {
                allTimeColorBlack()
                editor.putString("selected_time", "3")
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.time4Txt.id -> {
                allTimeColorBlack()
                editor.putString("selected_time", "4")
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade1Txt.id -> {
                allGradeColorBlack()
                editor.putString("selected_grade", "1")
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade2Txt.id -> {
                allGradeColorBlack()
                editor.putString("selected_grade", "2")
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade3Txt.id -> {
                allGradeColorBlack()
                editor.putString("selected_grade", "3")
                editor.commit()
                (v as TextView).setTextColor(Color.parseColor("#0046AA"))
            }
            binding.grade4Txt.id -> {
                allGradeColorBlack()
                editor.putString("selected_grade", "4")
                editor.commit()
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

    //SharedPreferences 정보 꺼내서 설정
    private fun setView(){
        val day=sharedPreferences.getString("selected_day", "")
        val time=sharedPreferences.getString("selected_time", "")
        val grade=sharedPreferences.getString("selected_grade", "")

        if(!day.isNullOrBlank()){
            val dayId = resources.getIdentifier("${day}_txt", "id", packageName)
            val textView = findViewById<TextView>(dayId)
            textView?.setTextColor(Color.parseColor("#0046AA")) //글자색
        }

        if(!time.isNullOrBlank()){
            val timeId = resources.getIdentifier("time${time}_txt", "id", packageName)
            val textView2 = findViewById<TextView>(timeId)
            textView2?.setTextColor(Color.parseColor("#0046AA")) //글자색
        }

        if(!grade.isNullOrBlank()){
            val gradeId = resources.getIdentifier("grade${grade}_txt", "id", packageName)
            val textView3 = findViewById<TextView>(gradeId)
            textView3?.setTextColor(Color.parseColor("#0046AA")) //글자색
        }
    }
}