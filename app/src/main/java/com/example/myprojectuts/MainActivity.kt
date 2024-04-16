package com.example.myprojectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition
import java.util.Objects

class MainActivity : AppCompatActivity() {
    private lateinit var bungaRecyclerView: RecyclerView
    private lateinit var bungaAdapter: MyAdapter
    private lateinit var listBunga : ArrayList<ItemData>
    private lateinit var nama : Array<String>
    private lateinit var gambar : Array<Int>
    private lateinit var deskrpsi : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_profil:Button = findViewById(R.id.btnProfile)
        btn_profil.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        gambar = arrayOf(
            R.drawable.anggrek,
            R.drawable.anthurium,
            R.drawable.dahlia,
            R.drawable.black_rose,
            R.drawable.bugenvil,
            R.drawable.flamboyan,
            R.drawable.kamboja,
            R.drawable.lavender,
            R.drawable.lily,
            R.drawable.matahari,
            R.drawable.mawar,
            R.drawable.raflesia,
            R.drawable.sakura,
            R.drawable.sepatu,
            R.drawable.teratai,
            R.drawable.tulip
        )

        nama = arrayOf(
            "anggrek",
            "anthurium",
            "dahlia",
            "black_rose",
            "bugenvil",
            "flamboyan",
            "kamboja",
            "lavender",
            "lily",
            "matahari",
            "mawar",
            "raflesia",
            "sakura",
            "sepatu",
            "teratai",
            "tulip"
        )

        deskrpsi = arrayOf(
            getString(R.string.black_rose),
            getString(R.string.raflesia),
            getString(R.string.anggrek),
            getString(R.string.anthurium),
            getString(R.string.bugenvil),
            getString(R.string.dahlia),
            getString(R.string.flamboyan),
            getString(R.string.lavender),
            getString(R.string.kamboja),
            getString(R.string.lily),
            getString(R.string.matahari),
            getString(R.string.mawar),
            getString(R.string.sakura),
            getString(R.string.sepatu),
            getString(R.string.teratai),
            getString(R.string.tulip)
        )


        bungaRecyclerView=findViewById(R.id.BungaRV)
        bungaRecyclerView.layoutManager = LinearLayoutManager (this )
        bungaRecyclerView.setHasFixedSize(true)

      listBunga = arrayListOf()
        getDataUser()
    }

    private fun getDataUser() {
        for (i in gambar.indices) {
            val databunga = ItemData(gambar[i],nama[i])
            listBunga.add(databunga)

        }
        var adapter = MyAdapter(listBunga)
        bungaRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object:MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int){
                intent= Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("idgambar", listBunga[position].gambar)
                intent.putExtra("idnama", listBunga[position].nama)
                intent.putExtra("iddeskripsi", deskrpsi[position])

                startActivity(intent)

            }


        })
    }


}

