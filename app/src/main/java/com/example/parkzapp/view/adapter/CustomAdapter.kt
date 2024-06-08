package com.example.parkzapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.parkzapp.R // Make sure this import is correct
import com.example.parkzapp.databinding.ServiceTicketBinding
import com.example.parkzapp.model.pojo.Services

class CustomAdapter(
    private val context: Context,
    private var data: List<Services>
) : BaseAdapter() {
    private lateinit var binding: ServiceTicketBinding

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // Check if convertView is null, and inflate the layout if needed
        if (convertView == null) {
            binding = ServiceTicketBinding.inflate(inflater, parent, false)
        } else {
            // If convertView is not null, reuse it
            binding = ServiceTicketBinding.bind(convertView)
        }

        // Set data to the views using the binding object
        binding.tvTitle.text = data[position].name
        try {
            Glide
                .with(context)
                .load(data[position].icon)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivService)
        } catch (ae: Exception) {
            // Handle Glide exception if needed
        }

        return binding.root
    }
}
