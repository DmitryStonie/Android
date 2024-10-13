package com.example.lab1

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ValuteSpinnerAdapter(context: Context, resource: Int, resource2: Int, valutes: List<Valute>) :
    ArrayAdapter<Valute>(context, resource, resource2, valutes) {
    private var _inflater: LayoutInflater = LayoutInflater.from(context)
    private val _layout = resource
    private val _valutes: List<Valute> = valutes

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup) : View{
        val view = _inflater.inflate(this._layout, parent, false)

        val codeView = view.findViewById<TextView>(R.id.spinner_text)
        val valute: Valute = _valutes[position]
        codeView.text = valute.CharCode
        return view
    }
}