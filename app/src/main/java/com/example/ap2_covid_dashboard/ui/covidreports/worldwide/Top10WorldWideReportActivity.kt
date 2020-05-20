package com.example.ap2_covid_dashboard.ui.covidreports.worldwide

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.api.covidreports.CovidWSClient
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetAllReportResponse
import com.example.ap2_covid_dashboard.ui.covidreports.worldwide.adapter.Top10WorldWideReportAdapter
import com.example.ap2_covid_dashboard.ui.shared.ItemSpacingDecoration
import kotlinx.android.synthetic.main.activity_top10_world_wide_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Top10WorldWideReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top10_world_wide_report)
        getData()
    }

    fun getData() {
        CovidWSClient().getAllReports()
            .enqueue(object : Callback<GetAllReportResponse> {
                override fun onFailure(call: Call<GetAllReportResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<GetAllReportResponse>,
                    response: Response<GetAllReportResponse>
                ) {
                    if (response.isSuccessful) {
                        // Creating a new List with TOP 10 County Cases
                        val top10 = response.body()?.data?.sortedByDescending { it.cases }?.take(10)

                        rankingRecyclerView.apply {
                            layoutManager = LinearLayoutManager(this@Top10WorldWideReportActivity)
                            addItemDecoration(
                                ItemSpacingDecoration(
                                    30
                                )
                            )
                            adapter = Top10WorldWideReportAdapter(top10!!)
                        }
                    }
                }
            })
    }
}
