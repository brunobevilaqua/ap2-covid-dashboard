package com.example.ap2_covid_dashboard.api.covidreports.worldwide

import com.google.gson.annotations.SerializedName

data class GetAllReportResponse(
    @SerializedName("data")
    var data: List<Data>
)