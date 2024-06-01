package com.example.wallpapeapp.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wallpapeapp.adapter.collectionadapter
import com.example.wallpapeapp.databinding.FragmentDownloadBinding
import java.io.File


class DownloadFragment : Fragment() {

      lateinit var binding : FragmentDownloadBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDownloadBinding.inflate(layoutInflater , container, false)

        val allFiles:Array<File>
        val imagelist = arrayListOf<String>()

       val targetPath = Environment.getExternalStorageDirectory().absolutePath+"/Pictures/XD WALLPAPER"

        val targetFile = File(targetPath)
        allFiles=targetFile.listFiles()!!

        for( data in allFiles)
        {
            imagelist.add(data.absolutePath)

        }

     binding.rcbcollection.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL  )
        binding.rcbcollection.adapter=collectionadapter(requireContext(),imagelist)


        return binding.root
    }


}