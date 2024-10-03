package com.example.lab3

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.background)

        var elements = fillList()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(RecyclerViewDecoration(16.dpToPx(this)))
        val adapter = ItemAdapter(elements)
        adapter.setOnClickListener(object :
            ItemAdapter.OnClickListener {
            override fun onClick(position: Int, model: ListItem) {
                when (val element = elements[position]) {
                    is Song -> {
                        val intent = Intent(this@MainActivity, SongActivity::class.java)
                        intent.putExtra("song_screen", element)
                        startActivity(intent)
                    }
                    is Advertisement -> {
                        val intent = Intent(this@MainActivity, AdActivity::class.java)
                        intent.putExtra("ad_screen", element)
                        startActivity(intent)
                    }
                    else -> {
                        val intent = Intent(this@MainActivity, SongActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
        recyclerView.adapter = adapter


        val handler: Handler = Handler()
        handler.postDelayed(Runnable {
            val newElements = ArrayList<ListItem>()
            newElements.add(elements[0])
            newElements.add(Advertisement(getString(R.string.technology), getString(R.string.twitter_has_a_new_boss), getString(R.string.big_changes_are_coming)))
            (1..< elements.size).forEach{ i -> newElements.add(elements[i])}
            newElements.add(Advertisement(getString(R.string.technology), getString(R.string.twitter_has_a_new_boss), getString(R.string.big_changes_are_coming)))

            (recyclerView.adapter as ItemAdapter).setData(newElements)
            val productDiffUtilCallback = ProductDiffUtilCallback(elements, newElements);
            val productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback);
            productDiffResult.dispatchUpdatesTo(recyclerView.adapter as ItemAdapter)
            elements = newElements
        }, 5000)
    }
    private fun fillList(): List<ListItem> {
        val data = mutableListOf<ListItem>()
        (0..14).forEach { i -> data.add(Song(getString(R.string.no_hay_ley), getString(R.string.kali_uchis)))}
        return data
    }
    fun Int.dpToPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()
}