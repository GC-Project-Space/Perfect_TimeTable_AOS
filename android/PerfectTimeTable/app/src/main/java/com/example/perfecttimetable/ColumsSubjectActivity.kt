package com.example.perfecttimetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perfecttimetable.Adapter.SubjectCAdapter
import com.example.perfecttimetable.databinding.ActivityColumsSubjectBinding

class ColumsSubjectActivity : AppCompatActivity() {

    private lateinit var binding:ActivityColumsSubjectBinding
    private lateinit var adapter: SubjectCAdapter

    private lateinit var choiceList:MutableList<Subject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityColumsSubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러 뷰설정
        //todo : linkRecycler(dataList)

        //todo : 상세보기 클릭시 넘어가기 (리사이클러뷰의 리스너 사용하기)

        //추가하기 버튼 누르면
        adapter.setOnAddClickListener(object : SubjectCAdapter.OnAddClickListener {
            override fun onAddClick(item: Subject) {
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
        })


    }

    //리사이클러 뷰 연결
    private fun linkRecyclr(subjectList:List<Subject>){
        //어댑터가 Initialized 되지 않았으면
        if(!::adapter.isInitialized){
            adapter= SubjectCAdapter(this, subjectList as MutableList<Subject>)
            val layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.subjectListRecy.layoutManager=layoutManager
            binding.subjectListRecy.adapter=adapter

        }else{
            adapter.updateData(subjectList)
        }
    }
}