package com.example.perfecttimetable

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perfecttimetable.Adapter.SubjectCAdapter
import com.example.perfecttimetable.Algo.Chosen
import com.example.perfecttimetable.Algo.Execute
import com.example.perfecttimetable.databinding.ActivityColumsSubjectBinding
import com.example.perfecttimetable.databinding.ActivityCreateNewTimeTableBinding

class CreateNewTimeTableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNewTimeTableBinding
    private lateinit var adapter: SubjectCAdapter

    private var choiceList: MutableList<SubjectList> = mutableListOf() //선택한 과목 리스트

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCreateNewTimeTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = listOf(
            SubjectList("세계와언어", 0, false),
            SubjectList("인간과예술", 0, false),
            SubjectList("사회와역사",0,false),
            SubjectList("기초교양", 0, false),
            SubjectList("일반교양", 0, false)
        )

        //리사이클러 뷰설정
        linkRecyclr(dataList)

        //추가하기 버튼 누르면
        adapter.setOnAddClickListener(object : SubjectCAdapter.OnAddClickListener {
            override fun onAddClick(item: SubjectList) {
                // 아이템의 추가 버튼 클릭 시 동작
                // choiceList에 아이템 추가
                Log.d("onAddClick", "onAddClick 엑티비티")
                choiceList.add(item)

                // 어댑터의 데이터(dataList)에서도 해당 아이템을 찾아 상태 변경
                val position = adapter.dataList.indexOf(item)
                if (position != -1) {
                    adapter.dataList[position].isChoice = true
                    adapter.notifyItemChanged(position) // 해당 아이템만 업데이트
                    Log.d("추가하기", "아마 추가가 됨")
                }
            }
        })

        choiceList.add(SubjectList("전공",2, true))

        //todo : 시간표 만들기 버튼 누르기
        binding.createNewBtn.setOnClickListener {

            var sharedPreferences: SharedPreferences = getSharedPreferences("setting", MODE_PRIVATE)

            Chosen.day = sharedPreferences.getString("selected_day", "").toString()
            Chosen.gap = sharedPreferences.getInt("selected_time", 2)+1
            Chosen.grade =sharedPreferences.getInt("selected_grade", 2)

            //todo:시간표 짜기 알고리즘
            val execute = Execute(this)
            val subList= execute.main(choiceList)
            SubList.list=subList.toMutableList()

            // 로그 추가 - subList 내용 확인
            Log.d("SubList 정보 :", "SubList: $subList")

            val intent= Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelableArrayList("subList", ArrayList(subList))
            bundle.putString("title", binding.titleEtxt.text.toString())

            intent.putExtra("bundle", bundle)

            startActivity(intent)
            finish()
        }

        //메뉴로 이동
        binding.menuBtn.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent) //피니쉬는 하지마
        }


        binding.icBackBtn.setOnClickListener {
            finish()
        }

    }

    //리사이클러 뷰 연결
    private fun linkRecyclr(subjectList:List<SubjectList>){
        //어댑터가 Initialized 되지 않았으면
        if(!::adapter.isInitialized){
            adapter= SubjectCAdapter(this, subjectList as MutableList<SubjectList>)
            val layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.subjectListRecy.layoutManager=layoutManager
            binding.subjectListRecy.adapter=adapter

        }else{
            adapter.updateData(subjectList)
        }
    }
}