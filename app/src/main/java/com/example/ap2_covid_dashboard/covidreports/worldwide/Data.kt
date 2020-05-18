package com.example.ap2_covid_dashboard.covidreports.worldwide

import com.google.gson.annotations.SerializedName
import java.util.*

data class Data(
    @SerializedName("country")
    var country: String,

    @SerializedName("cases")
    var cases: Int,

    @SerializedName("confirmed")
    var confirmed: Int,

    @SerializedName("deaths")
    var deaths: Int,

    @SerializedName("recovered")
    var recovered: Int,

    @SerializedName("updated_at")
    var updated_at: Date
)
