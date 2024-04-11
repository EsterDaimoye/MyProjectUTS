package com.example.myprojectuts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val namalist: ArrayList<ItemData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(Listener: onItemClickListener){
        mListener = Listener
    }


    class MyViewHolder (itemData : View,listener:onItemClickListener): RecyclerView.ViewHolder(itemData){
        val gambar : ImageView = itemData.findViewById(R.id.idGambar)
        val nama : TextView = itemData.findViewById(R.id.idNama)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val itemData = LayoutInflater.from(parent.context).inflate(R.layout.xample_item,parent,false)
        return MyViewHolder(itemData, mListener)
    }

    override fun getItemCount(): Int = namalist.size



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namalist[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
    }

}