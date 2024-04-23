package com.example.myprojectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.myprojectuts.databinding.ActivityLoginBinding
import com.example.myprojectuts.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener{
            val email : String = binding.editTextTextEmailAddress2.text.toString().trim()
            val password : String = binding.editTextPassword.text.toString().trim()
            val configpassword : String = binding.editTextConfigPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.editTextTextEmailAddress2.error = "Input Email"
                binding.editTextTextEmailAddress2.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextTextEmailAddress2.error = "Invalid Email"
                binding.editTextTextEmailAddress2.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length< 6){
                binding.editTextPassword.error = "Paasword must be more than 6 characters"
                binding.editTextPassword.requestFocus()
                return@setOnClickListener
            }
            if (password != configpassword){
                binding.editTextConfigPassword.error = "password must be match"
                binding.editTextConfigPassword.requestFocus()
                return@setOnClickListener
            }
        }

        binding.tvLogin.setOnClickListener{
            startActivity(Intent(this, Login::class.java))


        }
    }
}

