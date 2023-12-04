package com.example.perfecttimetable.Algo

import android.content.SharedPreferences
import com.example.perfecttimetable.Subject

object Chosen {
    var chosens = mutableListOf<MutableList<Subject>>(
    )
    var grade:Int = 2
    var gap:Int= 2
    var day:String=""
}