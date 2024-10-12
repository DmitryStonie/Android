package com.example.lab2_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.lab2_2.SecondFragment.Companion.THIRD_FRAGMENT


class FirstFragment : Fragment() {
    companion object {
        const val SECOND_FRAGMENT = "SecondFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                val fragmentManager = parentFragmentManager
                fragmentManager.commit {
                    add(R.id.fragment_container_view, SecondFragment())
                    addToBackStack(SECOND_FRAGMENT)
                }
            }
    }
}