package com.gcoders.health.bmi_calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var weight: EditText? = null
    private var height: EditText? = null
    private var calc: Button? = null
    private val result: TextView? = null
    private var resulttext: TextView? = null
    private val bmi: Float = 0.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById<View>(R.id.weight) as EditText
        height = findViewById<View>(R.id.height) as EditText
        resulttext = findViewById<View>(R.id.result) as TextView
        calc = findViewById(R.id.calculate_bmi_btn)

        calc!!.setOnClickListener { calculateBMI() }
    }


    fun calculateBMI() {
        val weightStr = weight!!.text.toString()
        val heightStr = height!!.text.toString()

        if ("" != heightStr && "" != weightStr) {
            val heightValue = java.lang.Float.parseFloat(heightStr) / 100
            val weightValue = java.lang.Float.parseFloat(weightStr)

            val bmi = weightValue / (heightValue * heightValue)
            resulttext!!.visibility = View.VISIBLE
            resulttext!!.text = "Calcualted BMI Level : $bmi"
        }
    }

}




