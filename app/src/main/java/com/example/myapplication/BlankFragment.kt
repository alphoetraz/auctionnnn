package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {




        val bind = FragmentBlankBinding.inflate(layoutInflater)


        bind.button11.setOnClickListener {
            val intent = Intent(this@BlankFragment.requireContext(), Additem::class.java )
            startActivity(intent)
        }



        bind.button14.setOnClickListener {
            val intent = Intent(this@BlankFragment.requireContext(), seeproduct::class.java )
            startActivity(intent)
        }








        return bind.root
    }

}

