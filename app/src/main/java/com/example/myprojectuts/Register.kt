package com.example.myprojectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myprojectuts.databinding.ActivityLoginBinding
import com.example.myprojectuts.databinding.ActivityRegisterBinding

class Register: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        binding.tvLogin.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity(intent)

        }
    }
}