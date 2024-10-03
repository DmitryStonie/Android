package com.example.lab3

data class Advertisement(
    val type: String,
    val title: String,
    val description: String,
    val photo: String,
): ListItem {
    override fun getListItemType(): Int {
        return ListItem.Type.TypeAd.ordinal
    }
}