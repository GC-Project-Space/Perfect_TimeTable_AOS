package com.example.perfecttimetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.perfecttimetable.databinding.ActivityChooseSubjectBinding

class ChooseSubjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseSubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChooseSubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}