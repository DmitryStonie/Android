package com.example.lab1

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    lateinit var valutes: ArrayList<Valute>
    lateinit var valuteAdapter: ValuteAdapter
    lateinit var valuteSpinnerAdapter1: ValuteSpinnerAdapter
    lateinit var valuteSpinnerAdapter2: ValuteSpinnerAdapter
    lateinit var topSelection: Valute
    lateinit var bottomSelection: Valute
    lateinit var topEditText:  EditText
    lateinit var bottomEditText:  EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        valutes = ArrayList<Valute>()

        valuteAdapter = ValuteAdapter(this, R.layout.valute_item, valutes)
        val valutesList = findViewById<ListView>(R.id.valutes_list)
        valutesList.adapter = valuteAdapter

        val valutes2 = ArrayList<Valute>()
        valuteSpinnerAdapter1 =
            ValuteSpinnerAdapter(this, R.layout.spinner_item, R.id.spinner_text, valutes)
        valuteSpinnerAdapter2 =
            ValuteSpinnerAdapter(this, R.layout.spinner_item, R.id.spinner_text, valutes)
        val valutesTopSpinner = findViewById<Spinner>(R.id.spinner_top)
        val valutesBottomSpinner = findViewById<Spinner>(R.id.spinner_bottom)
        valutesTopSpinner.adapter = valuteSpinnerAdapter1
        valutesBottomSpinner.adapter = valuteSpinnerAdapter1

        val model = ViewModelProvider(this).get(MyViewModel::class.java)
        model.getValue().observe(this) { value: ArrayList<Valute> ->
            value.forEach {
                valutes.add(it)
                valutes2.add(it)
            }
            topSelection = valutes[0]
            bottomSelection = valutes[0]
            valuteAdapter.notifyDataSetChanged()
            valuteSpinnerAdapter1.notifyDataSetChanged()
            valuteSpinnerAdapter2.notifyDataSetChanged()
        }
        model.execute()

        topEditText = findViewById<EditText>(R.id.valute_text_top)
        bottomEditText = findViewById<EditText>(R.id.valute_text_bottom)

        valutesTopSpinner.setOnItemSelectedListener(getTopSpinnerListener())
        valutesBottomSpinner.setOnItemSelectedListener(getBottomSpinnerListener())

        var hasChanged: Boolean = false
        topEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(hasChanged == false) {
                    hasChanged = true
                }else {
                    hasChanged = false
                    return
                }
                try {
                    val money = s.toString().toDouble()
                    updateBottomText(money)
                } catch (e: NumberFormatException){
                    topEditText.setText("")
                }
            }
        })
        bottomEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(hasChanged == false) {
                    hasChanged = true
                }else {
                    hasChanged = false
                    return
                }
                try {
                    val money = s.toString().toDouble()
                    updateTopText(money)
                } catch (e: NumberFormatException){
                    topEditText.setText("")
                }
            }
        })
    }

    private fun getTopSpinnerListener(): AdapterView.OnItemSelectedListener {
        val topItemSelectedListener: AdapterView.OnItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    try {
                        val item = parent.getItemAtPosition(position) as Valute
                        topSelection = item
                        val money = bottomEditText.text.toString().toDouble()
                        updateTopText(money)
                    } catch (e: NumberFormatException){
                        topEditText.setText("")
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        return topItemSelectedListener
    }

    private fun getBottomSpinnerListener(): AdapterView.OnItemSelectedListener {
        val bottomItemSelectedListener: AdapterView.OnItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    try {
                        val item = parent.getItemAtPosition(position) as Valute
                        bottomSelection = item
                        val money = topEditText.text.toString().toDouble()
                        updateBottomText(money)
                    } catch (e: NumberFormatException){
                        topEditText.setText("")
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        return bottomItemSelectedListener
    }
    private fun updateTopText(money: Double){
        val result = (money * bottomSelection.Value / bottomSelection.Nominal) / (topSelection.Value / topSelection.Nominal)
        if(result > 0.01){
            topEditText.setText(String.format("%.2f", result))
        } else{
            topEditText.setText(String.format("%.4f", result))
        }
    }

    private fun updateBottomText(money: Double){
        val result = (money * topSelection.Value / topSelection.Nominal) / (bottomSelection.Value / bottomSelection.Nominal)
        if(result > 0.01){
            bottomEditText.setText(String.format("%.2f", result))
        } else{
            bottomEditText.setText(String.format("%.4f", result))
        }
    }
}