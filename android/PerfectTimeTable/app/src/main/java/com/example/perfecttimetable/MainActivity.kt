package com.example.perfecttimetable

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.perfecttimetable.databinding.ActivityColumsSubjectBinding
import com.example.perfecttimetable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //todo : 저장된 시간표가 있다면 불러오기


        //시간표 만들기로 넘어가기
        binding.createNewTableTxt.setOnClickListener {
            val intent=Intent(this, ActivityColumsSubjectBinding::class.java)
            startActivity(intent)
        }

        // todo : 만들어진 시간표 정보 설정

    }

    //시간표 정보 설정 함수
    private fun setContent(subList:List<SubjectResult>){
        //시간표 이름 설정
        binding.timeTableNameTxt.text=title

        //시간표 설정
        for (item in subList){
            val resourceId = resources.getIdentifier("${item.day}_${item.time}", "id", packageName)
            val textView = findViewById<TextView>(resourceId)
            textView?.text = item.title // 제목 설정
            textView?.setTextColor(Color.parseColor("#000000")) //글자색
            textView?.setBackgroundColor(Color.parseColor("#FFE2EFFF")) //배경색
        }

    }
}