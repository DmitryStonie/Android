package com.example.lab2_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit


class ThirdFragment : Fragment() {
    companion object {
        const val SECOND_FRAGMENT = "SecondFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                val fragmentManager = parentFragmentManager
                fragmentManager.popBackStack(
                    SECOND_FRAGMENT,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
            }
    }
}