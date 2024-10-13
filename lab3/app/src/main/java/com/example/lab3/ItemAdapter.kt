package com.example.lab3

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private var items: List<ListItem>) :
    RecyclerView.Adapter<BaseViewHolder>() {
    private var onClickListener: OnClickListener? = null

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            ListItem.Type.Ad.value -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.ad_item, parent, false)
                return AdViewHolder(view)
            }

            ListItem.Type.Song.value -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
                return SongViewHolder(view)
            }

            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.ad_item, parent, false)
                return AdViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        Log.d(TAG, "bind, position = " + position);
        if (holder is SongViewHolder) {
            holder.bind(items[position] as Song)
        } else if (holder is AdViewHolder) {
            holder.bind(items[position] as Advertisement)
        }
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, items[position])
        }
    }

    fun setData(items: List<ListItem>) {
        this.items = items
    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: ListItem)
    }
}
