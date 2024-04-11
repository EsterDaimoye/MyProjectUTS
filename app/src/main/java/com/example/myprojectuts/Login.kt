package com.example.myprojectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myprojectuts.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvRegister.setOnClickListener{
            val intent = Intent(this,Register::class.java)
            startActivity(intent)

        }
        binding.tvForgetPassword.setOnClickListener{
            val intent = Intent(this,ForgetPassword::class.java)
            startActivity(intent)

        }
    }
}