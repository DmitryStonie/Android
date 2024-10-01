package com.example.lab1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ValuteAdapter(context: Context, resource: Int, valutes: List<Valute>) :
    ArrayAdapter<Valute>(context, resource, valutes) {
    private val _inflater: LayoutInflater = LayoutInflater.from(context)
    private val _layout = resource
    private val _valutes: List<Valute> = valutes

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = _inflater.inflate(this._layout, parent, false)

        val nameView = view.findViewById<TextView>(R.id.valute_name)
        val codeView = view.findViewById<TextView>(R.id.valute_code)
        val valueView = view.findViewById<TextView>(R.id.valute_value)

        val valute: Valute = _valutes[position]

        nameView.setText(valute.Name)
        codeView.setText(valute.CharCode)
        if(valute.Value / valute.Nominal < 0.01){
            valueView.setText(String.format("%.4f ₽", (valute.Value / valute.Nominal)))
        }else{
            valueView.setText(String.format("%.2f ₽", (valute.Value / valute.Nominal)))
        }
        return view
    }
}