package com.example.ap2_covid_dashboard.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.api.covidreports.CovidWSClient
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetAllReportResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        setOnClickListenerForButton()
    }

    private fun setOnClickListenerForButton() {
        openDashboard.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainDashboardActivity::class.java))
        })
    }

    private fun getData() {
        CovidWSClient().getAllReports()
            .enqueue(object : Callback<GetAllReportResponse> {
                override fun onFailure(call: Call<GetAllReportResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<GetAllReportResponse>,
                    response: Response<GetAllReportResponse>
                ) {
                    if (response.isSuccessful) {
                        var totalWorldCases = 0
                        var totalBrazilCases = 0

                        // Order List by Country Name
                        val orderedList =
                            response.body()?.data?.forEach {
                                totalWorldCases += it.cases
                                if (it.country.equals("Brazil")) {
                                    totalBrazilCases = it.cases
                                }
                            }
                        totalCasesBrazil.text =
                            "Total de Casos no Brasil: " + totalBrazilCases.toString()
                        totalCasesWorld.text =
                            "Total de Casos no Mundo: " + totalWorldCases.toString()
                    }
                }
            })
    }
}