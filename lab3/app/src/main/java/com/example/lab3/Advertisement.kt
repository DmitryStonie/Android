package com.example.lab3
import java.io.Serializable

data class Advertisement(
    val adType: String,
    val title: String,
    val description: String
): ListItem, Serializable {
    override val type: Int
        get() = ListItem.Type.Ad.value
}