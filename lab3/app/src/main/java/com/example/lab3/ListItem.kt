package com.example.lab3

interface ListItem {
    enum class Type(value: Int) {TypeSong(0), TypeAd(1) }
    fun getListItemType(): Int
}