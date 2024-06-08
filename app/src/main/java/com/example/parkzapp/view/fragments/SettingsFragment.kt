package com.example.parkzapp.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.parkzapp.R
import com.example.parkzapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    lateinit var binding:FragmentSettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSettingsBinding.inflate(inflater,container,false)
        initUi()
        return binding.root
    }

    private fun initUi() {
        try {
            Glide
                .with(requireContext())
                .load("https://reqres.in/img/faces/7-image.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivUser)
        }
        catch (ae:Exception)
        {
        }
    }
}