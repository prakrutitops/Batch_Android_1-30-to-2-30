package com.example.jsonview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter(var context:Context,var list:MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
       return position
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)
        var text:TextView =  view.findViewById(R.id.txt)
        var img:ImageView = view.findViewById(R.id.img)

        text.setText(list.get(position).name)
        //img.setImageResource(list.get(position).image)
        Picasso.get().load(list.get(position).image)
            .placeholder(R.mipmap.ic_launcher).resize(100,100)
            .centerCrop()
            .into(img)
        return view
    }

}