package com.example.ap2_covid_dashboard.ui

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.ui.covidreports.brazil.BrazilDashboardActivity
import com.example.ap2_covid_dashboard.ui.covidreports.worldwide.WorldWideDashboardActivity
import com.example.ap2_covid_dashboard.ui.menu.MenuItemAdapter
import com.example.ap2_covid_dashboard.ui.menu.MenuItemEnum
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MenuItemAdapter
    private val menuOptions =
        arrayListOf(MenuItemEnum.BRAZIL_REPORTS.item, MenuItemEnum.WORLD_REPORTS.item)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupMenuOption()
        setOnClickListenerForGridMenu()
    }

    private fun setupMenuOption() {
        adapter = MenuItemAdapter(
            this,
            menuOptions
        )
        reports.adapter = adapter
    }

    private fun setOnClickListenerForGridMenu() {
        val gridView = findViewById<GridView>(R.id.reports) as GridView

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val option = menuOptions[position]

                if (option.name.equals(MenuItemEnum.BRAZIL_REPORTS.item.name)) {
                    startActivity(Intent(this, BrazilDashboardActivity::class.java))
                }

                if (option.name.equals(MenuItemEnum.WORLD_REPORTS.item.name)) {
                    startActivity(Intent(this, WorldWideDashboardActivity::class.java))
                }
            }
    }
}