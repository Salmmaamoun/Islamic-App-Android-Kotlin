package com.example.islamicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.Adapters.SuraContentAdapter
import com.example.islamicapp.Adapters.SuraNameAdapter
import com.example.islamicapp.Fragments.QuranFragment
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.Charsets
import java.io.File

class SuraDetailsActivity : AppCompatActivity() {
    var suraPosition:Int?=null
    var suraName:String?=null
    lateinit var suraContentRecycleView:RecyclerView
    lateinit var suarContentAdapter:SuraContentAdapter
    lateinit var suraNameAdapter:SuraNameAdapter
    lateinit var arrowbackIc:ImageView
    lateinit var arrowCircle:ImageView
    lateinit var fragment: QuranFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suraContentRecycleView=findViewById(R.id.sura_details_recycleView)
        suarContentAdapter= SuraContentAdapter(null)
        suraName=intent.getStringExtra("EXTRA_SURA_NAME")
        suraPosition=intent.getIntExtra("EXTRA_SURA_POSISION",0)
        val suraNametv:TextView=findViewById(R.id.name_sura)
        suraNametv.text=suraName
        suraContentRecycleView.adapter=suarContentAdapter
        arrowbackIc=findViewById(R.id.arrow_back)
        arrowbackIc.setOnClickListener { finish() }
        arrowCircle=findViewById(R.id.arrow_circle)
        arrowCircle.setOnClickListener {
            val position=suraPosition!! +1
            val intent1= Intent( this,SuraDetailsActivity::class.java)
            intent1.putExtra("EXTRA_SURA_POSISION", position)
           // intent1.putExtra("EXTRA_SURA_NAME", fragment.suraNameList.elementAt(position))
            startActivity(intent1)

        }
        readFileText()

    }

    fun readFileText(){
        val fileNam="${suraPosition?.plus(1)}.txt"
        val fileContent=assets.open(fileNam).bufferedReader().use { it.readText() }
        val suraContent=fileContent.split('\n')
        suarContentAdapter.ubdateData(suraContent)
    }
    /*fun readFileDirectlyAsText(fileName: String): String
            = File(fileName).readText(Charsets.UTF_8)*/
}