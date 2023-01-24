package com.example.islamicapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R

class HadethContentAdapter(var hadethLine:List<String>?) : RecyclerView.Adapter<HadethContentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadethContentAdapter.ViewHolder {
        return HadethContentAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_line, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hadethlineText.text=hadethLine?.get(position)
    }
    override fun getItemCount(): Int {
        return hadethLine?.size?:0
    }
    fun ubdateData(suraLine:List<String?>?){
        this.hadethLine= suraLine as List<String>
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var hadethlineText: TextView =itemView.findViewById(R.id.hadeth_line_tv)

    }



}