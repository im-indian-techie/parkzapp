package com.example.parkzapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parkzapp.databinding.FragmentDashBoardBinding
import com.example.parkzapp.model.pojo.UserData
import com.example.parkzapp.utils.SpaceItemDecoration
import com.example.parkzapp.view.adapter.UserListRecycleAdapter
import com.example.parkzapp.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import dmax.dialog.SpotsDialog

@AndroidEntryPoint
class DashBoardFragment : Fragment() {
    lateinit var binding: FragmentDashBoardBinding
    var progressDialog:SpotsDialog?=null
    lateinit var adapter: UserListRecycleAdapter
    var list:ArrayList<UserData.Data> = arrayListOf()
    private val viewModel: DashboardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDashBoardBinding.inflate(inflater, container, false)
        initUi()
        return binding.root
    }

    private fun initUi() {
        adapter= UserListRecycleAdapter(context,list)
        binding.rvUser.adapter=adapter
        binding.rvUser.layoutManager=LinearLayoutManager(activity)
        binding.rvUser.addItemDecoration(SpaceItemDecoration(20))
        binding.rvUser.adapter=adapter
        progressDialog= SpotsDialog(context)
        viewModel.fetchData()
        viewModel.data.observe(viewLifecycleOwner, Observer {
           if(it.isNotEmpty())
           {
               list.clear()
               list.addAll(it)
               adapter.notifyDataSetChanged()
           }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if(it)
            {
              progressDialog!!.show()
            }
            else
            {
                progressDialog!!.dismiss()
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
        })
    }

}