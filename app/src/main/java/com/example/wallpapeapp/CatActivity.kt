package com.example.wallpapeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wallpapeapp.adapter.CatImageadapter
import com.example.wallpapeapp.databinding.ActivityCatBinding
import com.example.wallpapeapp.model.catmodel
import com.google.firebase.firestore.FirebaseFirestore

class CatActivity : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCatBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val db =FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")
        val name =intent.getStringExtra("name")

        db.collection("categories").document(uid!!).collection("wallpaper")
            .addSnapshotListener { value, error ->

            val ListofCatWallpaper= arrayListOf<catmodel>()
            val data=value?.toObjects(catmodel::class.java)
            ListofCatWallpaper.addAll(data!!)

            binding.catTitle.text=name.toString()
            binding.catCount.text="${ListofCatWallpaper.size} Wallpaper Available"

            binding.catRev.layoutManager =
                StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
             binding.catRev.adapter=CatImageadapter(this,ListofCatWallpaper)
        }


          }
}