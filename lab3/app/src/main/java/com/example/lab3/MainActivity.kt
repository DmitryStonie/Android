package com.example.lab3

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var elements = fillList()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(elements)
        recyclerView.addItemDecoration(RecyclerViewDecoration(16.dpToPx(this)))

        val handler: Handler = Handler()
        handler.postDelayed(Runnable { // Do something after 5s = 5000ms
            elements.add(1, Advertisement(getString(R.string.technology), getString(R.string.twitter_has_a_new_boss), getString(R.string.big_changes_are_coming), "@drawable/album_cover"))
            elements.add(Advertisement(getString(R.string.technology), getString(R.string.twitter_has_a_new_boss), getString(R.string.big_changes_are_coming), "@drawable/album_cover"))
            recyclerView.adapter?.notifyDataSetChanged()
        }, 5000)
    }
    private fun fillList(): ArrayList<ListItem> {
        val data = arrayListOf<ListItem>()
        (0..14).forEach { i -> data.add(Song(getString(R.string.no_hay_ley), getString(R.string.kali_uchis), "@drawable/album_cover"))}
        return data
    }
    fun Int.dpToPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()
}