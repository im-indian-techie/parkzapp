package com.example.parkzapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.parkzapp.R
import com.example.parkzapp.databinding.ActivityHomeBinding
import com.example.parkzapp.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binHomeBinding: ActivityHomeBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binHomeBinding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binHomeBinding.root)
        initUi()
    }

    private fun initUi() {
        navController=findNavController(R.id.nav_host_fragment)
        binHomeBinding.bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(object :NavController.OnDestinationChangedListener{
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                when(destination.id)
                {
                    R.id.homeFragment->
                    {
                        binHomeBinding.lltoolbar.tvTitle.text="Home"
                    }
                    R.id.dashBoardFragment->
                    {
                        binHomeBinding.lltoolbar.tvTitle.text="Welcome John Doe"
                    }
                    R.id.settingsFragment->
                    {
                        binHomeBinding.lltoolbar.tvTitle.text="Settings"
                    }
                }
            }

        })

    }
}