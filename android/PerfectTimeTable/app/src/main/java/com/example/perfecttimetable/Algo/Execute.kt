package com.example.perfecttimetable.Algo

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.perfecttimetable.Subject
import com.example.perfecttimetable.SubjectList

class Execute(con: Context) {

    val context=con

    fun changeHour(hour: Int): Int {
        return hour - 8
    }

    fun main(inp: List<SubjectList>): List<Subject> {
        Log.d("Execute 호출 : ","호출")


        val result = mutableListOf<Subject>()
        val db = Choice(context)
        for (i in inp) {
            db.choiceSubjectList(i, Chosen.grade)

            for (chosenSubjects in Chosen.chosens) {
                for (j in chosenSubjects) {
                    result.add(
                        Subject(
                            j.name,
                            j.courseCode,
                            changeHour(j.startTime),
                            j.day,
                            changeHour(j.endTime),
                            j.credit,
                            j.series
                        )
                    )
                }
            }

            for (i in result) {
               Log.d("Execute 결과 데이터 : ","${i.name} ${i.startTime} ${i.endTime} ${i.day}")
            }
        }
        return result
    }
}