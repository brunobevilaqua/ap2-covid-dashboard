package com.example.ap2_covid_dashboard.ui.covidreports.brazil

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.api.covidreports.CovidWSClient
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetReportByCountryResponse
import com.example.ap2_covid_dashboard.ui.covidreports.shared.ReportEnum
import kotlinx.android.synthetic.main.activity_brazil_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrazilReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brazil_report)
        getData()
    }

    fun getData() {
        CovidWSClient().getBrazilReport()
            .enqueue(object : Callback<GetReportByCountryResponse> {
                override fun onFailure(call: Call<GetReportByCountryResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<GetReportByCountryResponse>,
                    response: Response<GetReportByCountryResponse>
                ) {
                    if (response.isSuccessful) {
                        brazilTotalNumberOfCases.text =
                            ReportEnum.NUMBER_CASES.label + response.body()?.data?.cases.toString()

                        brazilTotalConfirmedCases.text =
                            ReportEnum.CONFIRMED.label + response.body()?.data?.confirmed.toString()

                        brazilTotalRecoveredNumber.text =
                            ReportEnum.RECOVERED.label + response.body()?.data?.recovered.toString()

                        brazilTotalOfDeaths.text =
                            ReportEnum.DEATHS.label + response.body()?.data?.deaths.toString()

                        brazilReportUpdateDate.text =
                            ReportEnum.UPDATE_AT.label + response.body()?.data?.updated_at.toString()
                    }
                }
            })
    }
}
