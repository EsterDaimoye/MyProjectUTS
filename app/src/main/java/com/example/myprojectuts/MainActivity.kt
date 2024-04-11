package com.example.myprojectuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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



        bungaRecyclerView=findViewById(R.id.BungaRV)
        listBunga = ArrayList()

        listBunga.add(ItemData(R.drawable.black_rose, "black rose"))
        listBunga.add(ItemData(R.drawable.kamboja, "Kamboja"))
        listBunga.add(ItemData(R.drawable.matahari, "Matahari"))
        listBunga.add(ItemData(R.drawable.lily, "Lily"))
        listBunga.add(ItemData(R.drawable.raflesia, "Raflesia"))
        listBunga.add(ItemData(R.drawable.tulip, "Tulip"))
        listBunga.add(ItemData(R.drawable.anthurium, "Anthurium"))
        listBunga.add(ItemData(R.drawable.anggrek, "Anggrek"))
        listBunga.add(ItemData(R.drawable.dahlia, "Dahlia"))
        listBunga.add(ItemData(R.drawable.bugenvil, "Bugenvil"))
        listBunga.add(ItemData(R.drawable.sakura, "Sakura"))
        listBunga.add(ItemData(R.drawable.sepatu, "Sepatu"))
        listBunga.add(ItemData(R.drawable.teratai, "Teratai"))
        listBunga.add(ItemData(R.drawable.lavender, "Lavender"))
        listBunga.add(ItemData(R.drawable.mawar, "Mawar"))
        listBunga.add(ItemData(R.drawable.flamboyan, "Flamboyan"))

        bungaRecyclerView.layoutManager= LinearLayoutManager(this)
        bungaRecyclerView.setHasFixedSize(true)
        bungaAdapter = MyAdapter(listBunga)
        bungaRecyclerView.adapter = bungaAdapter
    }
}