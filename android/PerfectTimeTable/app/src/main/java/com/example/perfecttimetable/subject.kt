package com.example.perfecttimetable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//과목명
@Parcelize
data class SubjectList( //교양 계열
    val title: String,
    var wantCredit:Int, //듣고 싶은 학점
    var isChoice:Boolean //무시
) : Parcelable

@Parcelize
data class Subject(
    val name: String,
    val courseCode:String,
    val startTime: Int,
    val day: String,
    val endTime: Int,
    val credit: String,
    val series: String
) : Parcelable

//in : SubjectList)
// (in : ChoicList, Subject )겹치는거 확인하는 부분 (out : Boolean)

// 1. 전공 선택
//끝하고
// 2. 교양 선택

// (in : SubjectList, ChoicList)교양 최우선 선택 (out : Subject)
// 최우선 없으면 차선 선택

//최종 out : ChoicList)