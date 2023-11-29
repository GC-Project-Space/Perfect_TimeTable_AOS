package com.example.perfecttimetable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//과목명
@Parcelize
data class SubjectList(
    val title: String,
    val series: String, //전공, 융합교양, 기초교양 ( int )
    val list: List<String>, //학수번호 리스트
    var isChoice:Boolean
) : Parcelable

@Parcelize
data class Subject( //과목 상세 디테일
    val title: String,
    val subNum:String,
    val startTime:Int, //12:00 같은 시간이 아니라, 1교시 같은 교시 기준 (1교시 단위)
    val endTime:Int,
    val day:String //요일
) : Parcelable

//in : SubjectList)
// (in : ChoicList, Subject )겹치는거 확인하는 부분 (out : Boolean)

// 1. 전공 선택
//끝하고
// 2. 교양 선택

// (in : SubjectList, ChoicList)교양 최우선 선택 (out : Subject)
// 최우선 없으면 차선 선택

//최종 out : ChoicList)