package com.selin.calculatorapp_bootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNumber(view: View) {
        if (newOp) {
            findViewById<TextView>(R.id.tvResult).setText("")
        }
        val newOp = false

        var result = findViewById<TextView>(R.id.tvResult)

        var btnChoose = view as Button
        var btnValues: String = result.text.toString()

        when(btnChoose.id){
            R.id.zero -> {
                btnValues += "0"
            }
            R.id.one -> {
                btnValues += "1"
            }
            R.id.two -> {
                btnValues += "2"
            }
            R.id.three -> {
                btnValues += "3"
            }
            R.id.four -> {
                btnValues += "4"
            }
            R.id.five -> {
                btnValues += "5"
            }
            R.id.six -> {
                btnValues += "6"
            }
            R.id.seven -> {
                btnValues += "7"
            }
            R.id.eight -> {
                btnValues += "8"
            }
            R.id.nine -> {
                btnValues += "9"
            }
        }
        result.setText(btnValues)
    }

    var operator = "*"
    var oldNumber = ""
    var newOp = true

    fun onOperator(view: View) {
        var result = findViewById<TextView>(R.id.tvResult)
        var btnChoose = view as Button

        when(btnChoose.id){
            R.id.multiply -> {
                operator = "*"
            }
            R.id.divide -> {
                operator = "/"
            }
            R.id.plus -> {
                operator = "+"
            }
            R.id.minus -> {
                operator = "-"
            }
        }
        oldNumber = result.text.toString()
        newOp = true
    }

    fun onEqual(view: View){
        var result = findViewById<TextView>(R.id.tvResult)
        var newNumber = result.text.toString()
        var resultNumber:Int?=null
        when(operator){
            "*" -> {
                resultNumber = oldNumber.toInt() * newNumber.toInt()
            }
            "/" -> {
                resultNumber = oldNumber.toInt() / newNumber.toInt()
            }
            "+" -> {
                resultNumber = oldNumber.toInt() + newNumber.toInt()
            }
            "-" -> {
                resultNumber = oldNumber.toInt() - newNumber.toInt()
            }
        }
        result.setText(resultNumber.toString())
        newOp = true
    }

    fun onClear(view: View){
        var result = findViewById<TextView>(R.id.tvResult)
        result.setText("")
        newOp = true
    }
}