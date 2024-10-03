package com.example.lab3

import android.view.View
import android.widget.TextView

class AdViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val headline: TextView = itemView.findViewById(R.id.headline)
    private val overline: TextView = itemView.findViewById(R.id.overline)
    private val supportingText: TextView = itemView.findViewById(R.id.supporting_text)

    override fun bind(item: ListItem) {
        val itemSong = item as Advertisement
        headline.text = itemSong.type
        overline.text = itemSong.title
        supportingText.text = itemSong.description
    }
}