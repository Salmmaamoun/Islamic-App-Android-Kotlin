package com.example.islamicapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R

class HadethNameAdapter(val items:List<String>): RecyclerView.Adapter<HadethNameAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethNameAdapter.ViewHolder {
        return HadethNameAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_name, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HadethNameAdapter.ViewHolder, position: Int) {
        holder.hadethNameTv.text=items.get(position)
        holder.hadethNameTv.setOnClickListener {
            onitemClick?.onHadethNameClick(items.get(position),position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val hadethNameTv: TextView =itemView.findViewById(R.id.item_hadeth_name)

    }
    var onitemClick:OnitemClick?=null
    interface OnitemClick{
        fun onHadethNameClick(hadeth:String,position: Int)
    }



}
