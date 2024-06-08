package com.example.parkzapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parkzapp.R
import com.example.parkzapp.databinding.UserTicketBinding
import com.example.parkzapp.model.pojo.UserData

class UserListRecycleAdapter(val context: Context?, val list:List<UserData.Data>): RecyclerView.Adapter<UserListRecycleAdapter.UserViewHolder>() {
   lateinit var binding:UserTicketBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        binding= UserTicketBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return UserViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val item = list[position]
        binding.tvName.text= "${item.firstName} ${item.lastName}"
        binding.tvEmail.text=item.email
        try {
            Glide
                .with(context!!)
                .load(item.avatar)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivUser)
        }
        catch (ae:Exception)
        {
        }


    }


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}