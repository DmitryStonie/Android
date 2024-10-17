package com.example.lab3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_activity)

        (intent.getSerializableExtra(MainActivity.SONG_SCREEN) as Song?)?.let {
            findViewById<TextView>(R.id.headline).text = it.name
            findViewById<TextView>(R.id.supporting_text).text = it.description
        }
    }
}