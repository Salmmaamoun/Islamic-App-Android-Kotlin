package com.example.islamicapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.islamicapp.R

class SebhaFragment : Fragment() {
    lateinit var bodySebhaImg:ImageView
    lateinit var numOfTasbeeh:TextView
    lateinit var tasbeehTv:TextView
    var counter:Int=1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bodySebhaImg=view.findViewById(R.id.body_sebha)
        numOfTasbeeh=view.findViewById(R.id.counter)
        tasbeehTv=view.findViewById(R.id.tasbeeh_tv)
        bodySebhaImg.setOnClickListener {
            onSebhaClicked()
        }
    }

    private fun onSebhaClicked() {
        bodySebhaImg.rotation=bodySebhaImg.rotation+1
        counter++
        numOfTasbeeh.text="${counter}"

        conditonNumOfTasbeeh()
    }
    private fun conditonNumOfTasbeeh(){
        if(counter==34){
            if(tasbeehTv.text=="سبحان الله"){
                tasbeehTv.text="الحمد لله"
                counter=0
                numOfTasbeeh.text="${counter}"
            }else if (tasbeehTv.text=="الحمد لله"){
                tasbeehTv.text="لا اله الا الله"
                counter=0
                numOfTasbeeh.text="${counter}"
            }else if (tasbeehTv.text=="لا اله الا الله"){
                tasbeehTv.text="الله اكبر"
                counter=0
                numOfTasbeeh.text="${counter}"
            }else if (tasbeehTv.text=="الله اكبر"){
                tasbeehTv.text="سبحان الله"
                counter=0
                numOfTasbeeh.text="${counter}"
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

}