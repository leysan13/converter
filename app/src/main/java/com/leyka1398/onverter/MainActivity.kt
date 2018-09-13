package com.leyka1398.onverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener({ _ ->
            run {

                GetCourse(spin1.selectedItem.toString(),spin2.selectedItem.toString())
            }
        })


    }
    fun GetCourse(from: String, to: String) {

        result.visibility = View.VISIBLE
        result_val.visibility = View.VISIBLE

        if (from == to) {
            result_val.setText("1.00")
        }
        if (from == "USD" && to == "RUB") {
            result_val.setText("68.531")
        }
        if (from == "USD" && to == "EUR") {
            result_val.setText("0.861")
        }
        if (from == "RUB" && to == "EUR") {
            result_val.setText("0.013")
        }
        if (from == "RUB" && to == "USD") {
            result_val.setText("0.015")
        }
        if (from == "EUR" && to == "USD") {
            result_val.setText("1.162")
        }
        if (from == "EUR" && to == "RUB") {
            result_val.setText("79.578")
        }
    }
}
