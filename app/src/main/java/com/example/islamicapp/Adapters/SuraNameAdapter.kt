package com.example.islamicapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R

class SuraNameAdapter(val items:List<String>): RecyclerView.Adapter<SuraNameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suraNameTv.text=items.get(position)
        holder.suraNameTv.setOnClickListener{
            onitemClick?.onSuraNameClick(items.get(position),position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val suraNameTv:TextView=itemView.findViewById(R.id.item_sura_name)

    }
    var onitemClick:OnitemClick?=null
    interface OnitemClick{
        fun onSuraNameClick(sura:String,position: Int)
    }


}