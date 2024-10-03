package com.example.lab3

data class Song(
    val name: String,
    val description: String,
    val photo: String,
): ListItem {
    override fun getListItemType(): Int {
        return ListItem.Type.TypeSong.ordinal
    }
}