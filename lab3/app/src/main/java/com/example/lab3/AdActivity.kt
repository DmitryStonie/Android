package com.example.lab3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AdActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ad_activity)

        var advertisement:Advertisement?=null
        if(intent.hasExtra("ad_screen")){
            advertisement = intent.getSerializableExtra("ad_screen") as Advertisement
        }
        if(advertisement!=null){
            findViewById<TextView>(R.id.overline).text = advertisement.type
            findViewById<TextView>(R.id.headline).text = advertisement.title
            findViewById<TextView>(R.id.supporting_text).text = advertisement.description
        }
    }
}