package com.example.lab2_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.lab2_2.Constants.SECOND_FRAGMENT


class FirstFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                val transaction = parentFragmentManager
                transaction.commit {
                    replace(R.id.fragment_container_view, SecondFragment())
                    setReorderingAllowed(true)
                    addToBackStack(SECOND_FRAGMENT)
                }
            }
        return view
    }
}