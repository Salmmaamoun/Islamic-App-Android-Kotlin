package com.example.islamicapp

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.Adapters.HadethContentAdapter
import com.example.islamicapp.Adapters.SuraContentAdapter
import com.example.islamicapp.Adapters.SuraNameAdapter
import com.example.islamicapp.Fragments.QuranFragment

class HadethDetailsActivity : AppCompatActivity() {
    var hadethPosition:Int?=null
    var hadethName:String?=null
    lateinit var hadethContentRecycleView: RecyclerView
    lateinit var hadethContentAdapter: HadethContentAdapter
    lateinit var arrowbackIc: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        hadethContentRecycleView=findViewById(R.id.hadeth_details_recycleView)
        hadethContentAdapter= HadethContentAdapter(null)
        hadethName=intent.getStringExtra("EXTRA_SURA_NAME")
        hadethPosition=intent.getIntExtra("EXTRA_SURA_POSISION",0)
        val hadethNametv: TextView =findViewById(R.id.name_hadeth)
        hadethNametv.text=hadethName
        hadethContentRecycleView.adapter=hadethContentAdapter
        arrowbackIc=findViewById(R.id.arrow_back)
        arrowbackIc.setOnClickListener { finish() }
        readFileText()
    }
    fun readFileText(){
        val fileName="2/h${hadethPosition?.plus(1)}.txt"
        val assetManager:AssetManager=assets
        val fileContent=assets.open(fileName).bufferedReader().use { it.readText() }
        val hadethContent=fileContent.split('\n')
        hadethContentAdapter.ubdateData(hadethContent)
    }
}