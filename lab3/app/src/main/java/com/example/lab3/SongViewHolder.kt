package com.example.lab3

import android.view.View
import android.widget.TextView

class SongViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val headline: TextView = itemView.findViewById(R.id.headline)
    private val overline: TextView = itemView.findViewById(R.id.supporting_text)

    override fun bind(item: ListItem) {
        val itemSong = item as Song
        headline.text = itemSong.name
        overline.text = itemSong.description
    }
}