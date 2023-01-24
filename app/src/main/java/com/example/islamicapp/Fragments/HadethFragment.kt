package com.example.islamicapp.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.Adapters.HadethNameAdapter
import com.example.islamicapp.Adapters.SuraNameAdapter
import com.example.islamicapp.HadethDetailsActivity
import com.example.islamicapp.R
import com.example.islamicapp.SuraDetailsActivity

class HadethFragment : Fragment() {
    lateinit var hadethNameAdapter: HadethNameAdapter
    lateinit var recyclerView: RecyclerView
    val hadethNameList=listOf<String>(
            "حديث رقم 1", "حديث رقم 2", "حديث رقم 3",  "حديث رقم 4" ,"حديث رقم 5","حديث رقم 6", "حديث رقم 7", "حديث رقم 8", "حديث رقم 9 ", "حديث رقم 10" ,"حديث رقم 11","حديث رقم 12", "حديث رقم 13", "حديث رقم 14",  "حديث رقم 15" ,"حديث رقم 16","حديث رقم 17", "حديث رقم 18", "حديث رقم 19", "حديث رقم 20", "حديث رقم 21" ,"حديث رقم 22","حديث رقم 23", "حديث رقم 24", "حديث رقم 25",  "حديث رقم 26" ,"حديث رقم 27","حديث رقم 28", "حديث رقم 29", "حديث رقم 30", "حديث رقم 31 ", "حديث رقم 32" ,"حديث رقم 33",
        "حديث رقم 34", "حديث رقم 35", "حديث رقم 36",  "حديث رقم 37" ,"حديث رقم 38","حديث رقم 39", "حديث رقم 40", "حديث رقم 41", "حديث رقم 42 ", "حديث رقم 43" ,"حديث رقم 44",
        "حديث رقم 45", "حديث رقم 46", "حديث رقم 47",  "حديث رقم 48" ,"حديث رقم 49","حديث رقم 50")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById<RecyclerView>(R.id.hadethNameRecyclerView)
        hadethNameAdapter=HadethNameAdapter(hadethNameList)
        hadethNameAdapter.onitemClick=object : HadethNameAdapter.OnitemClick{
            override fun onHadethNameClick(hadeth: String, position: Int) {
                val intent1= Intent( requireActivity(), HadethDetailsActivity::class.java)
                intent1.putExtra("EXTRA_SURA_POSISION",position)
                intent1.putExtra("EXTRA_SURA_NAME",hadeth)
                startActivity(intent1)
            }

        }
        recyclerView.adapter=hadethNameAdapter
    }


}