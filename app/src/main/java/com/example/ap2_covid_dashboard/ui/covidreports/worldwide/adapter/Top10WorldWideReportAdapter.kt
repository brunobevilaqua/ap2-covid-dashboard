package com.example.ap2_covid_dashboard.ui.covidreports.worldwide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.api.covidreports.worldwide.Data
import com.example.ap2_covid_dashboard.ui.covidreports.shared.ReportEnum
import kotlinx.android.synthetic.main.top_10_country_report_layout.view.*

class Top10WorldWideReportAdapter(private val top10List: List<Data>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CountryReportsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.top_10_country_report_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CountryReportsViewHolder -> {
                holder.bind(top10List[position], position + 1)
            }
        }
    }

    override fun getItemCount(): Int {
        return top10List.size
    }

    class CountryReportsViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.top10CountryName;
        val cases: TextView = itemView.top10Cases;
        val confirmed: TextView = itemView.top10Confirmed;
        val recovered: TextView = itemView.top10Recovered;
        val deaths: TextView = itemView.top10Deaths;
        val rankingPosition: TextView = itemView.top10RankingPosition

        fun bind(data: Data, rankPosition: Int) {
            name.text = data.country
            cases.text = ReportEnum.NUMBER_CASES.label + data.cases.toString()
            confirmed.text = ReportEnum.CONFIRMED.label + data.confirmed.toString()
            recovered.text = ReportEnum.RECOVERED.label + data.recovered.toString()
            deaths.text = ReportEnum.DEATHS.label + data.deaths.toString()
            rankingPosition.text = rankPosition.toString()
        }
    }
}