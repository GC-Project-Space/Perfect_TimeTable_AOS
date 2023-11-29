package com.example.perfecttimetable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perfecttimetable.Adapter.SubjectCAdapter
import com.example.perfecttimetable.databinding.ActivityColumsSubjectBinding
import com.example.perfecttimetable.databinding.ActivityCreateNewTimeTableBinding

class CreateNewTimeTableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNewTimeTableBinding
    private lateinit var adapter: SubjectCAdapter

    private lateinit var choiceList:MutableList<SubjectList> //선택한 과목 리스트

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCreateNewTimeTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러 뷰설정
        //todo : linkRecycler(dataList)

        //todo : 상세보기 클릭시 넘어가기 (리사이클러뷰 아이템)

        //추가하기 버튼 누르면
        /*adapter.setOnAddClickListener(object : SubjectCAdapter.OnAddClickListener {
            override fun onAddClick(item: SubjectList) {
                // 아이템의 추가 버튼 클릭 시 동작
                // choiceList에 아이템 추가
                choiceList.add(item)

                // 어댑터의 데이터(dataList)에서도 해당 아이템을 찾아 상태 변경
                val position = adapter.dataList.indexOf(item)
                if (position != -1) {
                    adapter.dataList[position].isChoice = true
                    adapter.notifyItemChanged(position) // 해당 아이템만 업데이트
                }
            }
        })*/

        //todo : 시간표 만들기 버튼 누르기
        binding.createNewBtn.setOnClickListener {
            //todo:시간표 짜기 알고리즘

            val intent= Intent(this, MainActivity::class.java)
            val bundle = Bundle()
           // bundle.putParcelableArrayList("subList", ArrayList(subList))
            bundle.putString("title", binding.titleEtxt.text.toString())

            intent.putExtra("bundle", bundle)

            startActivity(intent)
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