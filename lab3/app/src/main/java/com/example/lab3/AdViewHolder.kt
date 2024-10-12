package com.example.lab3

import android.view.View
import android.widget.TextView

class AdViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val headline: TextView = itemView.findViewById(R.id.headline)
    private val overline: TextView = itemView.findViewById(R.id.overline)
    private val supportingText: TextView = itemView.findViewById(R.id.supporting_text)

    fun bind(advertisement: Advertisement) {
        headline.text = advertisement.title
        overline.text = advertisement.adType
        supportingText.text = advertisement.description
    }
}