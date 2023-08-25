package com.example.hafta6odevleri.Hafta6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.hafta6odevleri.R
import com.example.hafta6odevleri.databinding.FragmentHomePageBinding
import com.google.android.material.snackbar.Snackbar


class HomePageFragment : Fragment() {
    private lateinit var design: FragmentHomePageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = FragmentHomePageBinding.inflate(inflater, container, false)
        design.buttonLogin.setOnClickListener {
            val userName = design.editName.text.toString()
            val userPassword = design.editPassword.text.toString()

            if (design.editName.text.isNullOrEmpty() || design.editPassword.text.isNullOrEmpty()) {
                Snackbar.make(it, "Please fill empty fields", Snackbar.LENGTH_SHORT).show()
            } else {

                //veri transveri için:
                val passing = HomePageFragmentDirections.actionHomePageFragmentToSecondPageFragment( user = User(userName,userPassword)  )
                Navigation.findNavController(it).navigate(passing)
            }
        }
        return design.root

    }


}