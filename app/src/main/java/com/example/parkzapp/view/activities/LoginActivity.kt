package com.example.parkzapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.parkzapp.R
import com.example.parkzapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val activity=this
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        binding.btnLogin.setOnClickListener {
           if (isValid())
           {
               if(binding.etName.text.toString() == "ashindas" && binding.etPass.text.toString() == "123456")
               {
                   startActivity(Intent(activity,HomeActivity::class.java))
                   finish()
               }
               else
               {
                   Toast.makeText(activity,"Invalid Credentials",Toast.LENGTH_SHORT).show()
               }

           }
        }

    }
    private fun isValid():Boolean
    {
        var isValid=false
        if (binding.etName.text.toString().isEmpty())
        {
            Toast.makeText(activity,"Please Enter username/email",Toast.LENGTH_SHORT).show()
        }
        else if (binding.etPass.text.toString().isEmpty())
        {
            Toast.makeText(activity,"Please Enter password",Toast.LENGTH_SHORT).show()
        }
        else
        {
            isValid= true
        }
        return isValid
    }
}