package com.example.ap2_covid_dashboard.api.covidreports

import com.example.ap2_covid_dashboard.api.covidreports.brazil.GetBrazilianStateReportResponse
import com.example.ap2_covid_dashboard.api.covidreports.brazil.GetBrazilianStatesReportResponse
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetAllReportResponse
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetReportByCountryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CovidService {

    @GET(".")
    fun getAllBrazilianStatesReport(): Call<GetBrazilianStatesReportResponse>

    @GET("brazil")
    fun getBrazilReport(@Path("date") date: String): Call<GetBrazilianStatesReportResponse>

    @GET("brazil/{date}")
    fun getAllBrazilianStatesReportsByDate(@Path("date") date: String): Call<GetBrazilianStatesReportResponse>

    @GET("brazil/uf/{state}")
    fun getBrazilianStateReport(@Path("state") state: String): Call<GetBrazilianStateReportResponse>

    @GET("countries")
    fun getAllWorldWideReports(): Call<GetAllReportResponse>

    @GET("{country}")
    fun getReportByCountry(@Path("country") country: String): Call<GetReportByCountryResponse>

}