package com.example.agecalculator

import java.text.SimpleDateFormat
import java.util.*

    fun main(){
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
        print(currentDate!!.time/60000)
    }
