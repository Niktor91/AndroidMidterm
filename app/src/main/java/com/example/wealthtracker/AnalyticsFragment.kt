package com.example.wealthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class AnalyticsFragment : Fragment() {

    private val wealthManager = WealthManager()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_analytics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvIncome = view.findViewById<TextView>(R.id.nn_ze_tv_income_result)
        val tvExpenses = view.findViewById<TextView>(R.id.nn_ze_tv_expenses_result)
        val tvSavings = view.findViewById<TextView>(R.id.nn_ze_tv_savings_result)


        setFragmentResultListener("wealth_data") { _, bundle ->
            val income = bundle.getDouble("income")
            val expenses = bundle.getDouble("expenses")


            val savings = wealthManager.calculateFinalSavings(income, expenses)

            tvIncome.text = "Income: ₾%.2f".format(income)
            tvExpenses.text = "Expenses: ₾%.2f".format(expenses)
            tvSavings.text = "Final Savings: ₾%.2f".format(savings)
        }
    }
}