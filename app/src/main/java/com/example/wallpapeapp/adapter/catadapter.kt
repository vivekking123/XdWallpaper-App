package com.example.wallpapeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpapeapp.CatActivity
import com.example.wallpapeapp.R
import com.example.wallpapeapp.model.catmodel

class catadapter(
    val requireContext: Context,
    val ListofCat: ArrayList<catmodel>) : RecyclerView.Adapter<catadapter.bomViewHolder>(){

    inner class bomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val imageView =itemView.findViewById<ImageView>(R.id.cat_image)
        val name=itemView.findViewById<TextView>(R.id.cat_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_cat,parent,false)
        )
    }



    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
       holder.name.text=ListofCat[position].name
        Glide.with(requireContext).load(ListofCat[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {

            val intent = Intent(requireContext, CatActivity::class.java)
            intent.putExtra("uid",ListofCat[position].id)
            intent.putExtra("name",ListofCat[position].name)
            requireContext.startActivity(intent)

        }
    }

    override fun getItemCount()= ListofCat.size



}