package com.example.ap2_covid_dashboard.ui.covidreports.brazil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.api.covidreports.brazil.Data
import com.example.ap2_covid_dashboard.ui.covidreports.shared.ReportEnum
import kotlinx.android.synthetic.main.brazil_state_report_layout.view.*

class BrazilStateReportAdapter(val reports: List<Data>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BrazilStatesReportViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.brazil_state_report_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BrazilStatesReportViewHolder -> {
                holder.bind(reports[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return reports.size
    }

    class BrazilStatesReportViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val stateName: TextView = itemView.stateName;
        val cases: TextView = itemView.stateCases;
        val suspects: TextView = itemView.stateSuspectInfectionTotal;
        val deaths: TextView = itemView.stateTotalOfDeaths;
        val reportDate: TextView = itemView.stateReportDate;

        fun bind(data: Data) {
            stateName.text = data.uf
            cases.text = ReportEnum.NUMBER_CASES.label + data.cases.toString()
            suspects.text = ReportEnum.SUSPECTS.label + data.suspects.toString()
            deaths.text = ReportEnum.DEATHS.label + data.deaths.toString()
            reportDate.text = ReportEnum.REPORT_DATE.label + data.datetime.toString()
        }
    }
}