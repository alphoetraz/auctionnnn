package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentBlank4Binding


class BlankFragment4 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val bind = FragmentBlank4Binding.inflate(layoutInflater)

        bind.button6.setOnClickListener {
            val intent = Intent(this@BlankFragment4.requireContext(), MyOrders::class.java )
            startActivity(intent)
        }


        bind.button7.setOnClickListener {
            val intent = Intent(this@BlankFragment4.requireContext(), Rate::class.java)
            startActivity(intent)
        }



        bind.button8.setOnClickListener {
            val intent = Intent(this@BlankFragment4.requireContext(), Setting::class.java)
            startActivity(intent)
        }

        bind.button9.setOnClickListener {
            val intent = Intent(this@BlankFragment4.requireContext(), Helpa::class.java)
            startActivity(intent)
        }


        bind.button10.setOnClickListener {
            val intent = Intent(this@BlankFragment4.requireContext(), MyProducts::class.java)
            startActivity(intent)
        }

        bind.button5.setOnClickListener {
            val intent = Intent(this@BlankFragment4.requireContext(), MyProfil::class.java)
            startActivity(intent)
        }











        return bind.root
    }

}

