package com.example.perfecttimetable.Algo

import android.content.Context
import android.util.Log
import com.example.perfecttimetable.Constance
import com.example.perfecttimetable.Subject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException

class DataBase(con:Context) {
    val context=con
    var major: List<Map<String, Any>>
    var elective: List<Map<String, Any>>
    private val gson = Gson()

    init {
        major = loadJSONFromAsset("major.json") ?: emptyList()
        elective = loadJSONFromAsset("elective.json") ?: emptyList()

        // 데이터 출력
        Log.d("디비 major data:", "$major")
        Log.d("디비 elective data:", "$elective")
    }

    private fun loadJSONFromAsset(filename: String): List<Map<String, Any>>? {
        var json: String? = null
        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            Log.e("DataBase", "Error reading $filename: ${e.localizedMessage}")
        }

        return json?.let {
            try {
                val jsonArray = gson.fromJson(it, Any::class.java)
                if (jsonArray is List<*>) {
                    val mapList = mutableListOf<Map<String, Any>>()
                    for (item in jsonArray) {
                        if (item is Map<*, *>) {
                            @Suppress("UNCHECKED_CAST")
                            mapList.add(item as Map<String, Any>)
                        }
                    }
                    mapList
                } else {
                    null
                }
            } catch (ex: Exception) {
                Log.e("DataBase", "Error parsing $filename: ${ex.localizedMessage}")
                null
            }
        }
    }


    fun getCreditAreaData(credit: Int, area: String, day: String): List<Subject> {
        val resultData = elective.filter {
            it["영역"] == area && it["학점"].toString().toDouble()== credit.toDouble() && it["요일"] == day
        }

        // 데이터 출력
        Log.d("디비 Credit resultData:"," $credit, Area: $area, Day: $day -> $resultData")


        val result = mutableListOf<Subject>()
        for (i in resultData) {
            result.add(
                Subject(
                    i["교과목명"].toString(),
                    i["학수번호"].toString(), // Assuming "학수번호" is equivalent to "과목코드"
                    i["시작 시간"].toString().toDouble().toInt(), // Adjust key name to match JSON data
                    i["요일"].toString(),
                    i["끝 시간"].toString().toDouble().toInt(), // Adjust key name to match JSON data
                    i["학점"].toString(),
                    i["영역"].toString() // Assuming "영역" is equivalent to "시리즈"
                )
            )
        }

        // 데이터 출력
        Log.d("디비 Credit Subjext: ","$credit, Area: $area, Day: $day -> $result")

        return result
    }

    // get_major 메서드
    fun getMajor(): List<Subject> {
        val resultData = major.filter { item -> item["학년"].toString().toDouble() == Chosen.grade.toDouble() }

        val result = mutableListOf<Subject>()
        for (i in resultData) {
            val temp = i.toMutableMap() // Convert Map<String, Any> to MutableMap<String, Any>
            temp.remove("학년") // Remove unnecessary "학년" field
            val subject = Subject(
                temp["교과목명"].toString(),
                temp["학수번호"].toString(), // Assuming "학수번호" is equivalent to "과목코드"
                temp["시작 시간"].toString().toDouble().toInt(), // Adjust key name to match JSON data
                temp["요일"].toString(),
                temp["끝 시간"].toString().toDouble().toInt(), // Adjust key name to match JSON data
                temp["학점"].toString(),
                temp["영역"].toString() // Assuming "영역" is equivalent to "시리즈"
            )
            result.add(subject)
        }

        // 데이터 출력
        Log.d("디비 Major for Grade:"," ${Chosen.grade} -> $result")

        return result
    }

    // 다른 메서드들 추가...
}