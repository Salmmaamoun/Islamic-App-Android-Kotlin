package com.example.islamicapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R

class SuraContentAdapter(var suraLine:List<String>?) : RecyclerView.Adapter<SuraContentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sura_line,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suralineText.text=suraLine?.get(position)
    }

    override fun getItemCount(): Int {
        return suraLine?.size?:0
    }
    fun ubdateData(suraLine:List<String?>?){
        this.suraLine= suraLine as List<String>
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var suralineText:TextView=itemView.findViewById(R.id.sura_line_tv)

    }


}