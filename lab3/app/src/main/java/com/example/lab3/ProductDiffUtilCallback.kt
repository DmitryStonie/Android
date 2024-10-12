package com.example.lab3

import androidx.recyclerview.widget.DiffUtil

class ProductDiffUtilCallback(private val oldList: List<ListItem>,
                              private val newList: List<ListItem>
) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem: ListItem = oldList[oldItemPosition]
        val newItem: ListItem = newList[newItemPosition]
        return when {
            oldItem is Advertisement && newItem is Advertisement -> {
                true
            }
            oldItem is Song && newItem is Song -> {
                true
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem: ListItem = oldList[oldItemPosition]
        val newItem: ListItem = newList[newItemPosition]
        return when {
            oldItem is Advertisement && newItem is Advertisement -> {
                oldItem.title == newItem.title && oldItem.adType == newItem.adType && oldItem.description == newItem.description
            }
            oldItem is Song && newItem is Song -> {
                oldItem.name == newItem.name && oldItem.description == newItem.description
            }
            else -> false
        }
    }
}