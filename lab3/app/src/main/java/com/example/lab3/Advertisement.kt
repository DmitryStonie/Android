package com.example.lab3

data class Advertisement(
    val type: String,
    val title: String,
    val description: String
): ListItem, java.io.Serializable {
    override fun getListItemType(): Int {
        return ListItem.Type.TypeAd.ordinal
    }
}