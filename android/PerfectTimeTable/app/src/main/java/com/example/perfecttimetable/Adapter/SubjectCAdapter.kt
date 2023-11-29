package com.example.perfecttimetable.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.perfecttimetable.SubjectList
import com.example.perfecttimetable.databinding.ItemSubjectBinding

class SubjectCAdapter(
    private val context: Context,
    val dataList: MutableList<SubjectList>)
    : RecyclerView.Adapter<SubjectCAdapter.ViewHolder>(){

    // 추가 버튼 클릭 리스너 인터페이스 정의
    interface OnAddClickListener {
        fun onAddClick(item: SubjectList)
    }

    private var addClickListener: OnAddClickListener? = null

    fun setOnAddClickListener(listener: OnAddClickListener) {
        this.addClickListener = listener
    }

    //뷰 홀더
    inner class ViewHolder(
        private val binding: ItemSubjectBinding
    ): RecyclerView.ViewHolder(binding.root){

        init {
            // 추가 버튼 클릭 시 이벤트 설정
            binding.addTxt.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    addClickListener?.onAddClick(dataList[position]) // 추가 버튼 클릭 시 아이템 정보 전달
                }
            }
        }

        fun bind(item: SubjectList){
            binding.subjectNameTxt.text=item.title
            binding.columTxt.text=item.series

            //선탣된 과목은 파란색 글씨로 변경
            if(item.isChoice){
                binding.subjectNameTxt.setTextColor(Color.parseColor("#0046AA"))
            }

            binding.addTxt.setOnClickListener {  }

        }
    }

    // 뷰홀더를 생성하여 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    //뷰홀더 데이터 설정
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    //아이템 개수
    override fun getItemCount(): Int {
        return dataList.size
    }

    //데이터 업데이트 (모두 지우고 업데이트)
    fun updateData(newDataList:List<SubjectList>){
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}