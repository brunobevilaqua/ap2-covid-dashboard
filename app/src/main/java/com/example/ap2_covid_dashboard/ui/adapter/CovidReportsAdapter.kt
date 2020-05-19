package com.example.ap2_covid_dashboard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.Data
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.GetAllReportResponse
import com.example.ap2_covid_dashboard.ui.ReportEnum
import kotlinx.android.synthetic.main.country_report_layout.view.*

class CovidReportsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var reports: GetAllReportResponse

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CountryReportsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.country_report_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CountryReportsViewHolder -> {
                holder.bind(reports.data.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return reports.data.size
    }

    fun submitWorldWideReports(reports: GetAllReportResponse) {
        this.reports = reports
    }

    class CountryReportsViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.countryName;
        val cases: TextView = itemView.cases;
        val confirmed: TextView = itemView.confirmed;
        val deaths: TextView = itemView.recovered;
        val recovered: TextView = itemView.deaths;

        fun bind(data: Data) {
            name.text = data.country
            cases.text = ReportEnum.NUMBER_CASES.label + data.cases.toString()
            confirmed.text = ReportEnum.CONFIRMED.label + data.confirmed.toString()
            deaths.text = ReportEnum.DEATHS.label + data.deaths.toString()
            recovered.text = ReportEnum.RECOVERED.label + data.recovered.toString()
        }
    }

}