package com.example.parkzapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.parkzapp.R
import com.example.parkzapp.databinding.FragmentHomeBinding
import com.example.parkzapp.model.pojo.Services
import com.example.parkzapp.view.adapter.CustomAdapter
import java.util.Arrays


class HomeFragment : Fragment() {
   lateinit var binding: FragmentHomeBinding
   lateinit var adapter: CustomAdapter
   var list:ArrayList<Services>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)
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
        var services1= Services("Playground\nInspection", R.drawable.playground)
        var services2= Services("Building\nInspection", R.drawable.build)
        var services3= Services("Sports Field\nInspection", R.drawable.sports)
        var services4= Services("Ice Arena\nInspection", R.drawable.ice)
        var services5= Services("Fire\nInspection", R.drawable.fire)
        var services6= Services("Parking Lot\nInspection", R.drawable.group)
        list= arrayListOf()
        list!!.add(services1)
        list!!.add(services2)
        list!!.add(services3)
        list!!.add(services4)
        list!!.add(services5)
        list!!.add(services6)
        adapter = CustomAdapter(requireContext(),list!!)
        binding.gridView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}