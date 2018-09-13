package com.leyka1398.converter

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener({ _ ->
            run {

                GetCourse(spin1.selectedItem.toString(), spin2.selectedItem.toString())
            }
        })


    }

    fun GetCourse(from: String, to: String) {

        result.visibility = View.VISIBLE
        result_val.visibility = View.VISIBLE

        val query = from + "_" + to

        AsyncTaskConvert(query).execute()
        /* val url = "https://free.currencyconverterapi.com/api/v6/convert?q="+query+ "&compact=ultra"
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
         }*/
    }

    inner class AsyncTaskConvert(var query: String) : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String? {
            val call = ApiInterface.create().search(query, "ultra")
            val result = call.execute().body()
            Log.d("Leysan",result.toString())
            return result?.total_count.toString()
        }

        override fun onPostExecute(value: String?) {
            result_val.setText(value)
        }
    }
}



