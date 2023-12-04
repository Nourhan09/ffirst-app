package com.example.mytestingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView


class FirstFragment : Fragment() {
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var navView: BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Initialize the views
        textView2 = view.findViewById(R.id.textView2)
        textView3 = view.findViewById(R.id.textView3)
        navView = view as BottomNavigationView

        return view
    }
}
