package com.example.ap2_covid_dashboard.covidreports.brazil

import com.google.gson.annotations.SerializedName
import java.util.*

data class Data(
    @SerializedName("uid")
    var uid: Int,

    @SerializedName("uf")
    var uf: String,

    @SerializedName("state")
    var state: String,

    @SerializedName("cases")
    var cases: Int,

    @SerializedName("deaths")
    var deaths: Int,

    @SerializedName("suspects")
    var suspects: Int,

    @SerializedName("refuses")
    var refuses: Int,

    @SerializedName("broadcast")
    var broadcast: Boolean,

    @SerializedName("comments")
    var comments: String,

    @SerializedName("datetime")
    var datetime: Date
)

