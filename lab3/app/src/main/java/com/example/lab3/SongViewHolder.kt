package com.example.lab3

import android.view.View
import android.widget.TextView

class SongViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val headline: TextView = itemView.findViewById(R.id.headline)
    private val overline: TextView = itemView.findViewById(R.id.supporting_text)

    fun bind(song: Song) {
        headline.text = song.name
        overline.text = song.description
    }
}