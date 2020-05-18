package com.example.ap2_covid_dashboard.covidreports

import com.example.ap2_covid_dashboard.covidreports.brazil.GetBrazilianStateReportResponse
import com.example.ap2_covid_dashboard.covidreports.brazil.GetBrazilianStatesReportResponse
import com.example.ap2_covid_dashboard.covidreports.worldwide.GetAllReportResponse
import com.example.ap2_covid_dashboard.covidreports.worldwide.GetReportByCountryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CovidService {

    companion object {
        const val version = "/v1"
    }

    @GET(value = version)
    fun getAllBrazilianStatesReport(): Call<List<GetBrazilianStatesReportResponse>>

    @GET(value = "$version/brazil/{date}")
    fun getAllBrazilianStatesReportsByDate(@Path("date") date: String): Call<List<GetBrazilianStatesReportResponse>>

    @GET(value = "$version/brazil/uf/{state}")
    fun getBrazilianStateReport(@Path("state") state: String): Call<GetBrazilianStateReportResponse>

    @GET(value = "$version/countries")
    fun getAllWorldWideReports(): Call<List<GetAllReportResponse>>

    @GET(value = "$version/{country}")
    fun getReportByCountry(@Path("country") country: String): Call<List<GetReportByCountryResponse>>

}