package com.example.barapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    companion object val STATE_RESULT = "state_result"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate.setOnClickListener(this)
    if (savedInstanceState != null) {
        val result = savedInstanceState.getString(STATE_RESULT)
        tvResult.text = result
    }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        val inputLength = edtLength.text.toString().trim()
        val inputWidth = edtWidth.text.toString().trim()
        val inputHeigth = edtHeight.text.toString().trim()
        var isEmptyFields = false
        if (inputLength.isEmpty()) {
            isEmptyFields = true
            edtLength.error = "Field ini tidak boleh kosong!"
        }
        if (inputHeigth.isEmpty()) {
            isEmptyFields = true
            edtHeight.error = "Field ini tidak boleh kosong!"
        }
        if (inputWidth.isEmpty()) {
            isEmptyFields = true
            edtWidth.error = "Field ini tidak boleh kosong!"
        }
        if (!isEmptyFields) {
            val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeigth.toDouble()
            tvResult.text = volume.toString()
        }
    }
}