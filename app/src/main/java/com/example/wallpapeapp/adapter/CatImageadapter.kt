package com.example.wallpapeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpapeapp.Finalwallpaper
import com.example.wallpapeapp.R
import com.example.wallpapeapp.model.catmodel
import com.makeramen.roundedimageview.RoundedImageView

class CatImageadapter(
    val requireContext: Context,
    val Listofthemonth: ArrayList<catmodel>
) : RecyclerView.Adapter<CatImageadapter.bomViewHolder>(){

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

        Glide.with(requireContext).load(Listofthemonth[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext,Finalwallpaper::class.java)
            intent.putExtra("link",Listofthemonth[position].link)
            requireContext.startActivity(intent)

        }
    }

    override fun getItemCount()= Listofthemonth.size



}