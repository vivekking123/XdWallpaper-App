package com.example.wallpapeapp

import android.app.WallpaperManager
import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.WindowManager.InvalidDisplayException
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.wallpapeapp.databinding.ActivityFinalwallpaperBinding
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.File
import java.io.IOException
import java.io.OutputStream
import java.net.URL
import java.util.Objects
import java.util.Random;

class Finalwallpaper : AppCompatActivity() {

    lateinit var binding: ActivityFinalwallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalwallpaperBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val url = intent.getStringExtra("link")
        val urlImage = URL(url)


        Glide.with(this).load(url).into(binding.finalwallpaper )


            binding.btnSetWallpaper.setOnClickListener {
               //set wallpaper
                val result: Deferred<Bitmap?> = GlobalScope.async {
                    urlImage.toBitmap()
                }
                GlobalScope.launch(Dispatchers.Main) {
                    val wallpaperManager = WallpaperManager.getInstance(applicationContext)
                    wallpaperManager.setBitmap(result.await())

//
                }

            }


            binding.btnDownload.setOnClickListener {
          // set Download
                val result: Deferred<Bitmap?> = GlobalScope.async {
                    urlImage.toBitmap()
                }
                GlobalScope.launch(Dispatchers.Main) {
                    saveImage(result.await())
//
                }
            }
        }
       fun URL.toBitmap(): Bitmap? {
           return try {
               BitmapFactory.decodeStream(openStream())
           } catch (e: IOException){
               null
           }
       }

      private fun saveImage(image: Bitmap?){

          // error
          val random1 = Random().nextInt(952663)
          val random2 = Random().nextInt(520985)

          val name = "XDWAllPAPER-${random1+ random2}"

          val data: OutputStream
          try{
              val resolver = contentResolver
              val contentValues = ContentValues()
              contentValues.put(MediaStore.MediaColumns.DISC_NUMBER,"$name.jpg")
              contentValues.put(MediaStore.MediaColumns.MIME_TYPE,"$name/jpg")
              contentValues.put(
                  MediaStore.MediaColumns.RELATIVE_PATH,
                  Environment.DIRECTORY_PICTURES + File.separator + "XD WALLPAPER"
              )
              val imageUri =
                  resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                data = resolver.openOutputStream(Objects.requireNonNull(imageUri)!!)!!
              image?.compress(Bitmap.CompressFormat.JPEG, 100, data)
              Objects.requireNonNull<OutputStream?>(data)
              Toast.makeText(this,"Image Save" , Toast.LENGTH_SHORT).show()

          } catch (e: Exception) {
              Toast.makeText(this,"Image Not Save ", Toast.LENGTH_SHORT).show()
          }
      }


    }

class Random {

}
