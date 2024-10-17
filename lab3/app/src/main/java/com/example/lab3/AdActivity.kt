package com.example.lab3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ad_activity)

        (intent.getSerializableExtra(MainActivity.SONG_SCREEN) as Advertisement?)?.let {
            findViewById<TextView>(R.id.overline).text = it.adType
            findViewById<TextView>(R.id.headline).text = it.title
            findViewById<TextView>(R.id.supporting_text).text = it.description
        }
    }
}