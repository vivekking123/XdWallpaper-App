package com.example.wallpapeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wallpapeapp.databinding.ActivityMainBinding
import com.example.wallpapeapp.fragments.DownloadFragment
import com.example.wallpapeapp.fragments.HomeFragments

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN

        );
        setContentView(binding.root)
        fragmentreplace(HomeFragments())

        binding.icHome.setOnClickListener {
         fragmentreplace(HomeFragments())

        }

        binding.icDownlaod.setOnClickListener {
           fragmentreplace(DownloadFragment())
        }

    }

    fun fragmentreplace( fragments : Fragment) {
        val transction = supportFragmentManager.beginTransaction()
        transction.replace(R.id.FragmentReplace, fragments)
        transction.commit()
    }
}