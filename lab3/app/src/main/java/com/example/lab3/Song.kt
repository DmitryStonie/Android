package com.example.lab3

data class Song(
    val name: String,
    val description: String,
): ListItem, java.io.Serializable {
    override fun getListItemType(): Int {
        return ListItem.Type.TypeSong.ordinal
    }
}