package com.example.perfecttimetable

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.perfecttimetable.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //시간표 만들기로 넘어가기
        binding.createNewTableTxt.setOnClickListener {
            val intent=Intent(this, CreateNewTimeTableActivity::class.java)
            startActivity(intent)
        }

        // todo : 만들어진 시간표 정보 설정

        //메뉴로 넘어가기
        binding.menuBtn.setOnClickListener {
            val intent=Intent(this,SettingActivity::class.java)
            startActivity(intent)
        }

    }
    //시간표 정보 받아오기
    override fun onResume() {
        super.onResume()
        val bundle = intent.getBundleExtra("bundle")
        val receivedSubList: ArrayList<Subject>? = bundle?.getParcelableArrayList("subList")
        val receivedTitle: String? = bundle?.getString("title")

// 받은 데이터 사용 예시
        receivedSubList?.let { subList ->
            // subList를 사용하여 작업 수행
        }

        receivedTitle?.let { title ->
            // title을 사용하여 작업 수행
            binding.timeTableNameTxt.text=title
        }
    }

    //시간표 정보 설정 함수
    private fun setContent(subList:List<Subject>){
        //시간표 이름 설정
        binding.timeTableNameTxt.text=title

        //시간표 설정
        for (item in subList){
            for( time in item.startTime..item.endTime){
                val resourceId = resources.getIdentifier("${item.day}_${time}", "id", packageName)
                val textView = findViewById<TextView>(resourceId)
                textView?.text = item.title // 제목 설정
                textView?.setTextColor(Color.parseColor("#000000")) //글자색
                textView?.setBackgroundColor(Color.parseColor("#FFE2EFFF")) //배경색
            }
        }

    }
}