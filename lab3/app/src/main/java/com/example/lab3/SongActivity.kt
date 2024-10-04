package com.example.lab3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SongActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_activity)

        var song:Song?=null
        if(intent.hasExtra("song_screen")){
            song = intent.getSerializableExtra("song_screen") as Song
        }
        if(song!=null){
            findViewById<TextView>(R.id.headline).text = song.name
            findViewById<TextView>(R.id.supporting_text).text = song.description
        }
    }
}