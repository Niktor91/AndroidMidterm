package com.example.wealthtracker

class WealthManager {

    // K = (letters in first name + letters in last name) / birth day number
    // ნიკა = 4 ნოზაძე = 6  დაბადების რიცხვი 4
    // K = (4 + 6) / 14 = 0.714285
    private val k = (4 + 6).toDouble() / 14.0

    fun calculateFinalSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * k
    }

    fun getK(): Double = k
}