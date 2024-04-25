package com.example.myprojectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.myprojectuts.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener{
            val email : String = binding.editTextTextEmailAddress.text.toString().trim()
            val password : String = binding.editTextTextPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.editTextTextEmailAddress.error = "Input Email"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextTextEmailAddress.error = "Invalid Email"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length< 6){
                binding.editTextTextPassword.error = "Paasword must be more than 6 characters"
                binding.editTextTextPassword.requestFocus()
                return@setOnClickListener
            }
        }
        binding.tvRegister.setOnClickListener{
            startActivity(Intent(this , RegisterActivity::class.java))
        }
        binding.tvForgetPassword.setOnClickListener{
           Intent(this , ForgetPassword::class.java).also {
               startActivity(it)
           }
        }
    }
    private fun loginuser (email : String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
            if (it.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(it)
                }
            }
            else{
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null){
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(it)

            }
        }
    }
}
