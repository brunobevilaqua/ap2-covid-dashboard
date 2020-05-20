package com.example.ap2_covid_dashboard.ui.menu

import com.example.ap2_covid_dashboard.R

enum class MenuItemEnum(val item: MenuItem) {
    BRAZIL_REPORTS(
        MenuItem(
            "Covid - Brasil",
            R.drawable.brazil
        )
    ),
    WORLD_REPORTS(
        MenuItem(
            "Covid - Mundo",
            R.drawable.world
        )
    ),
    TOP_10(
        MenuItem(
            "Top 10 Rank em casos", R.drawable.top_10_rank
        )
    ),
    WORLD_REPORTS_2(
        MenuItem(
            "Relatórios de todos países",
            R.drawable.world
        )
    )
}