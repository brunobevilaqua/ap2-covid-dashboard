package com.example.ap2_covid_dashboard.covidreports

import com.example.ap2_covid_dashboard.shared.RetrofitClient
import retrofit2.Retrofit

class CovidWSClient {
    companion object {
        private const val BASE_URI = "https://covid19-brazil-api.now.sh/api/report"

        fun getClient(): Retrofit {
            return RetrofitClient.getWSClient(BASE_URI)
        }
    }
}