package com.example.recyclerviewex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context:Context,var list: MutableList<Model>) :RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
       var layout = LayoutInflater.from(context)
       var view = layout.inflate(R.layout.design,parent,false)
       return MyViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.image.setImageResource(list.get(position).image)
        holder.text.setText(list.get(position).name)
    }

}
class MyViewHolder(itemview: View) :RecyclerView.ViewHolder(itemview)
{
    var image = itemview.findViewById<ImageView>(R.id.img)
    var text = itemview.findViewById<TextView>(R.id.txt1)
}