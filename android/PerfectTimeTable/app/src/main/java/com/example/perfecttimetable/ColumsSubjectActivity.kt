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
    }
}