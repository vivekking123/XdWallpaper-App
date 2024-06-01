package com.example.wallpapeapp.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpapeapp.Finalwallpaper
import com.example.wallpapeapp.R
import com.example.wallpapeapp.model.colortonemodel

class colortoneadapter(
    val requireContext: Context,
    val ListTheColorTone: ArrayList<colortonemodel>) : RecyclerView.Adapter<colortoneadapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val cardBack =itemView.findViewById<CardView>(R.id.item_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_bomtom,parent,false)
        )
    }



    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        val color = ListTheColorTone[position].color
        holder.cardBack.setCardBackgroundColor(Color.parseColor(color))

        holder.itemView.setOnClickListener {

            holder.itemView.setOnClickListener {
                val intent = Intent(requireContext, Finalwallpaper::class.java)
                intent.putExtra("link",ListTheColorTone[position].link)
                requireContext.startActivity(intent)

            }

        }

    }

    override fun getItemCount()= ListTheColorTone.size



}