package com.example.ap2_covid_dashboard.ui.covidreports.brazil

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.api.covidreports.CovidWSClient
import com.example.ap2_covid_dashboard.api.covidreports.brazil.GetBrazilianStatesReportResponse
import com.example.ap2_covid_dashboard.ui.covidreports.brazil.adapter.BrazilStateReportAdapter
import com.example.ap2_covid_dashboard.ui.shared.ItemSpacingDecoration
import kotlinx.android.synthetic.main.activity_brazil_states_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrazilStatesReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brazil_states_report)
        getData()
    }

    fun getData() {
        CovidWSClient().getBrazilStatesReport()
            .enqueue(object : Callback<GetBrazilianStatesReportResponse> {
                override fun onFailure(call: Call<GetBrazilianStatesReportResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<GetBrazilianStatesReportResponse>,
                    response: Response<GetBrazilianStatesReportResponse>
                ) {
                    if (response.isSuccessful) {
                        // Order List by Country Name
                        val orderedList = response.body()?.data?.sortedWith(compareBy { it.uf })

                        brazilStatesReportRecyclerView.apply {
                            layoutManager = LinearLayoutManager(this@BrazilStatesReportActivity)
                            addItemDecoration(
                                ItemSpacingDecoration(
                                    30
                                )
                            )
                            adapter =
                                BrazilStateReportAdapter(orderedList!!)
                        }
                    }
                }
            })
    }
}
