package com.example.ap2_covid_dashboard.ui.covidreports.worldwide

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.ui.menu.MenuItemAdapter
import com.example.ap2_covid_dashboard.ui.menu.MenuItemEnum
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_world_wide_dashboard.*

class WorldWideDashboardActivity : AppCompatActivity() {

    private lateinit var adapter: MenuItemAdapter
    private val menuOptions =
        arrayListOf(MenuItemEnum.TOP_10.item, MenuItemEnum.WORLD_REPORTS_2.item)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world_wide_dashboard)
        setupMenuOption()
        setOnClickListenerForGridMenu()
    }

    private fun setupMenuOption() {
        adapter = MenuItemAdapter(
            this,
            menuOptions
        )
        wwReports.adapter = adapter
    }

    private fun setOnClickListenerForGridMenu() {
        val gridView = findViewById<GridView>(R.id.wwReports) as GridView

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val option = menuOptions[position]

                if (option.name.equals(MenuItemEnum.TOP_10.item.name)) {
                    startActivity(Intent(this, Top10WorldWideReportActivity::class.java))
                }

                if (option.name.equals(MenuItemEnum.WORLD_REPORTS_2.item.name)) {
                    startActivity(Intent(this, WorldWideReportActivity::class.java))
                }
            }
    }
}
