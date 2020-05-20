package com.example.ap2_covid_dashboard.ui.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.ap2_covid_dashboard.R
import com.example.ap2_covid_dashboard.ui.menu.MenuItem
import kotlinx.android.synthetic.main.main_menu_grid_layout.view.*

class MenuItemAdapter : BaseAdapter {
    var items = ArrayList<MenuItem>()
    var context: Context? = null

    constructor(context: Context, items: ArrayList<MenuItem>) : super() {
        this.context = context
        this.items = items
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = this.items[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var itemView = inflator.inflate(R.layout.main_menu_grid_layout, null)
        itemView.reportLogo.setImageResource(item.image!!)
        itemView.optionName.text = item.name!!

        return itemView
    }
}
