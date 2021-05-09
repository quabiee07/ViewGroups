package com.olgatech.viewgroups

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(context: Context, list:List<Model>):ArrayAdapter<Model>(context,0, list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val food  = getItem(position)

        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        }
        val img =view?.findViewById<ImageView>(R.id.foodImage)
        val name = view?.findViewById<TextView>(R.id.name)


        name?.text = food?.name
        food?.image?.let {
            img?.setImageResource(food.image)
        }
        view?.setOnClickListener {
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA, food?.image)
            intent.putExtra(NAME_EXTRA,food?.name)
            intent.putExtra(FOOD_EXTRA, food?.desc)
            parent.context.startActivity(intent)
        }

        return view!!
    }

    companion object{
        val LOGO_EXTRA = "logo_extras"
        val NAME_EXTRA = "name_extras"
        val FOOD_EXTRA = "food_extras"
    }


}