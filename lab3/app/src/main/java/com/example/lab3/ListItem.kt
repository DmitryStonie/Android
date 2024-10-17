package com.example.lab3

sealed interface ListItem {
    enum class Type(val value: Int) { Song(0), Ad(1) }

    val type: Int
}