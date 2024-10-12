package com.example.lab2_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit


class SecondFragment : Fragment() {
    companion object {
        const val THIRD_FRAGMENT = "ThirdFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                val fragmentManager = parentFragmentManager
                fragmentManager.commit {
                    add(R.id.fragment_container_view, ThirdFragment())
                    addToBackStack(THIRD_FRAGMENT)
                }
            }
    }
}