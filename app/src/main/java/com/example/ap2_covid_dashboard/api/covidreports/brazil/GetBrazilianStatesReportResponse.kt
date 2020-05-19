package com.example.ap2_covid_dashboard.api.covidreports.brazil

import com.google.gson.annotations.SerializedName

data class GetBrazilianStatesReportResponse(
    @SerializedName("data")
    var data: List<Data>
)