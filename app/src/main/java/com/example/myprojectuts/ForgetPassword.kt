package com.example.myprojectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import android.widget.Toast
import com.example.myprojectuts.databinding.ActivityForgetPasswordBinding
import com.example.myprojectuts.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetPassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)

        binding.tvForgetPassword.setOnClickListener{
            val email : String = binding.editTextTextEmailAddress.text.toString().trim()
            if (email.isEmpty()){
                binding.editTextTextEmailAddress.error = "Input Email"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editTextTextEmailAddress.error = "Input Email"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
        }
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
            if (it.isSuccessful) {
                Toast.makeText(this,  "cek email buat reset password", Toast.LENGTH_SHORT).show()
                Intent(this, LoginActivity::)
            }
        }
    }
}
