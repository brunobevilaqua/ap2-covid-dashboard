package com.example.ap2_covid_dashboard.api.covidreports

import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetAllReportResponse
import com.example.ap2_covid_dashboard.shared.RetrofitClient
import retrofit2.Call

class CovidWSClient() {

    private val BASE_URI = "https://covid19-brazil-api.now.sh/api/report/v1/"

    private val api : CovidService

    init {
        val retrofit = RetrofitClient.getWSClient(BASE_URI)
        api = retrofit.create(CovidService::class.java)
    }

    fun getAllReports() : Call<GetAllReportResponse> {
        return api.getAllWorldWideReports()
    }
}