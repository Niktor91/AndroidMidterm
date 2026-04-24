package com.example.wealthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etIncome = view.findViewById<EditText>(R.id.nn_ze_et_income)
        val etExpenses = view.findViewById<EditText>(R.id.nn_ze_et_expenses)
        val btnSave = view.findViewById<Button>(R.id.nn_ze_btn_save)

        btnSave.setOnClickListener {


            val incomeText = etIncome.text.toString().trim()
            val expensesText = etExpenses.text.toString().trim()

            if (incomeText.isEmpty()) {
                etIncome.error = "Please enter your income"
                return@setOnClickListener
            }

            if (expensesText.isEmpty()) {
                etExpenses.error = "Please enter your expenses"
                return@setOnClickListener
            }

            val income = incomeText.toDouble()
            val expenses = expensesText.toDouble()


            val bundle = Bundle().apply {
                putDouble("income", income)
                putDouble("expenses", expenses)
            }
            setFragmentResult("wealth_data", bundle)
        }
    }
}