package com.example.perfecttimetable


//뷰 만들때 쓰는 데이터 구조
data class Subject(
    val title: String,
    val colum:String,
    val time:Int, //12:00 같은 시간이 아니라, 1교시 같은 교시 기준
    val day:String, //요일
    val profName:String, //교수 이름
    val number:String, //학수 번호
    val place:String, //강의실 정보
    var isChoice:Boolean
)

//시간표 만들때 쓰는 데이터 구조
data class SubjectResult(
    val title: String,
    val time:Int, //12:00 같은 시간이 아니라, 1교시 같은 교시 기준 (1교시 단위)
    val day:String //요일
)
