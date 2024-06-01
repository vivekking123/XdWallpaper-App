package com.example.wallpapeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpapeapp.Finalwallpaper
import com.example.wallpapeapp.R
import com.makeramen.roundedimageview.RoundedImageView

class collectionadapter(
    val requireContext: Context,
    val Listofthemonth: ArrayList<String>
) : RecyclerView.Adapter<collectionadapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val imageView =itemView.findViewById<RoundedImageView>(R.id.catImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_wallpaper2,parent,false)
        )
    }



    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(Listofthemonth[position]).into(holder.imageView)

        }


    override fun getItemCount()= Listofthemonth.size



}