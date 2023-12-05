package com.example.perfecttimetable

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
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

        clearView()

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
        clearView()

        val bundle = intent.getBundleExtra("bundle")
        val receivedSubList: ArrayList<Subject>? = bundle?.getParcelableArrayList("subList")
        val receivedTitle: String? = bundle?.getString("title")

// 받은 데이터 사용 예시
        receivedSubList?.let { subList ->
            // subList를 사용하여 작업 수행
            setContent(subList)
        }

        receivedTitle?.let { title ->
            // title을 사용하여 작업 수행
            binding.timeTableNameTxt.text=title
        }
    }

    //시간표 정보 설정 함수
    private fun setContent(subList:List<Subject>){

        clearView()

        //시간표 이름 설정
        binding.timeTableNameTxt.text=title

        //시간표 설정
        for (item in subList){
            for( time in item.startTime..item.endTime){
                if(time==item.endTime){continue}
                val resourceId = resources.getIdentifier("${item.day}_${time}", "id", packageName)
                val textView = binding.root.findViewById<TextView>(resourceId)
                textView?.text = item.name // 제목 설정
                textView?.setTextColor(Color.parseColor("#000000")) //글자색
                textView?.setBackgroundColor(Color.parseColor("#FFE2EFFF")) //배경색
            }
        }

    }

    //뷰 초기화
    private fun clearView() {
            Log.d("뷰클리어!", "깨끗")

            for (time in 1..9) {
                val resourceId1 = resources.getIdentifier("${Constance.MONDAY}_${time}", "id", packageName)
                val resourceId2 = resources.getIdentifier("${Constance.THURSDAY}_${time}", "id", packageName)
                val resourceId3 = resources.getIdentifier("${Constance.WEDNESDAY}_${time}", "id", packageName)
                val resourceId4 = resources.getIdentifier("${Constance.TUESDAY}_${time}", "id", packageName)
                val resourceId5 = resources.getIdentifier("${Constance.FRIDAY}_${time}", "id", packageName)

                val textView1 = binding.root.findViewById<TextView>(resourceId1)
                textView1?.text = "" // Clear text
                textView1?.setTextColor(Color.parseColor("#000000")) // Set text color to black
                textView1?.setBackgroundColor(Color.parseColor("#FFFFFF")) // Set background color to white

                val textView2 = binding.root.findViewById<TextView>(resourceId2)
                textView2?.text = "" // Clear text
                textView2?.setTextColor(Color.parseColor("#000000")) // Set text color to black
                textView2?.setBackgroundColor(Color.parseColor("#FFFFFF")) // Set background color to white

                val textView3 = binding.root.findViewById<TextView>(resourceId3)
                textView3?.text = "" // Clear text
                textView3?.setTextColor(Color.parseColor("#000000")) // Set text color to black
                textView3?.setBackgroundColor(Color.parseColor("#FFFFFF")) // Set background color to white

                val textView4 = binding.root.findViewById<TextView>(resourceId4)
                textView4?.text = "" // Clear text
                textView4?.setTextColor(Color.parseColor("#000000")) // Set text color to black
                textView4?.setBackgroundColor(Color.parseColor("#FFFFFF")) // Set background color to white

                val textView5 = binding.root.findViewById<TextView>(resourceId5)
                textView5?.text = "" // Clear text
                textView5?.setTextColor(Color.parseColor("#000000")) // Set text color to black
                textView5?.setBackgroundColor(Color.parseColor("#FFFFFF")) // Set background color to white
            }

    }



}