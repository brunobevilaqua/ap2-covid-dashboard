package com.example.ap2_covid_dashboard.covidreports.brazil

import com.google.gson.annotations.SerializedName

data class GetBrazilianStatesReportResponse(
    @SerializedName("data")
    var data: List<Data>
)