package com.example.wallpapeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpapeapp.adapter.Bomadapter
import com.example.wallpapeapp.adapter.catadapter
import com.example.wallpapeapp.adapter.colortoneadapter
import com.example.wallpapeapp.databinding.FragmentHomeFragmentsBinding
import com.example.wallpapeapp.model.bomModel
import com.example.wallpapeapp.model.catmodel
import com.example.wallpapeapp.model.colortonemodel
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragments : Fragment() {

    lateinit var binding: FragmentHomeFragmentsBinding
    lateinit var db:FirebaseFirestore
    lateinit var Listofthemonth:ArrayList<bomModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeFragmentsBinding.inflate(layoutInflater, container, false)

        db = FirebaseFirestore.getInstance()

        db.collection("bestofthemonth").addSnapshotListener { value, error ->
            val Listofthemonth = arrayListOf<bomModel>()
            val data = value?.toObjects(bomModel::class.java)
            Listofthemonth.addAll(data!!)


            binding.rcbBom.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
            binding.rcbBom.adapter = Bomadapter(requireContext(), Listofthemonth)


        }


        db.collection("thecolortone").addSnapshotListener { value, error ->

            val ListTheColorTone = arrayListOf<colortonemodel>()
            val data = value?.toObjects(colortonemodel::class.java)
            ListTheColorTone.addAll(data!!)

            binding.rcbTct.layoutManager =
                LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
            binding.rcbTct.adapter=colortoneadapter(requireContext(),ListTheColorTone)

        }

        db.collection("categories").addSnapshotListener { value, error ->

            val ListofCategory= arrayListOf<catmodel>()
            val data=value?.toObjects(catmodel::class.java)
            ListofCategory.addAll(data!!)

            binding.rcbCat.layoutManager =GridLayoutManager(requireContext(),2)
            binding.rcbCat.adapter=catadapter(requireContext(),ListofCategory)
        }

            return binding.root

        }

}