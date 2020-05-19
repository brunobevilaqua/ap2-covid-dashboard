package com.example.ap2_covid_dashboard

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ap2_covid_dashboard.api.covidreports.CovidWSClient
import com.example.ap2_covid_dashboard.ui.adapter.CovidReportsAdapter
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetAllReportResponse
import com.example.ap2_covid_dashboard.ui.ItemSpacingDecoration
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var worldWideReportsAdapterAdapter: CovidReportsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        getData()
    }

    fun getData() {
        var serviceResponse: GetAllReportResponse? = null

        val call = CovidWSClient().getAllReports()
            .enqueue(object : Callback<GetAllReportResponse> {
                override fun onFailure(call: Call<GetAllReportResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<GetAllReportResponse>,
                    response: Response<GetAllReportResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            worldWideReportsAdapterAdapter.submitWorldWideReports(
                                it
                            )
                        }
                    }
                }
            })
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(ItemSpacingDecoration(30))
            worldWideReportsAdapterAdapter =
                CovidReportsAdapter()
            adapter = worldWideReportsAdapterAdapter
        }
    }

}