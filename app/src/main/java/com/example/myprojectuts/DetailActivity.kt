package com.example.myprojectuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gambar : ImageView = findViewById(R.id.iv_gambar)
        val nama : TextView = findViewById(R.id.tv_nama)
        val deskripsi : TextView = findViewById(R.id.tv_deskrpisi)

        val bundle : Bundle?= intent.extras
        val bNama = bundle!!.getString("idnama")
        val bGambar = bundle!!.getInt("idgambar")
        val bDeskripsi = bundle!!.getString("iddeskripsi")

        gambar.setImageResource(bGambar)
        nama.text=bNama
        deskripsi.text=bDeskripsi


    }
}