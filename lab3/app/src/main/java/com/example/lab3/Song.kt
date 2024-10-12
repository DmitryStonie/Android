package com.example.lab3
import java.io.Serializable

data class Song(
    val name: String,
    val description: String,
): ListItem, Serializable {
    override val type: Int
        get() = ListItem.Type.Song.value
}