package com.example.lab2_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit


class ThirdFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                val transaction = parentFragmentManager
                transaction.popBackStack("SecondFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                transaction.commit{
                    add(R.id.fragment_container_view, FirstFragment())
                    setReorderingAllowed(true)
                }
            }
        return view
    }
}