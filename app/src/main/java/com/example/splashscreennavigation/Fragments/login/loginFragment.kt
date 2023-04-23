package com.example.splashscreennavigation.Fragments.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.splashscreennavigation.R
import com.example.splashscreennavigation.databinding.LoginFragmentBinding

class loginFragment : Fragment(R.layout.login_fragment) {

        private var _binding: LoginFragmentBinding? = null
        private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        _binding = LoginFragmentBinding.bind(view)



        //FIRST WAY


        binding.button3.setOnClickListener { view ->
            view.findNavController().navigate(R.id.helloFragment)


        }

        //SECOND WAY


       /* binding.button3.setOnClickListener {
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.helloFragment)
        }*/




}
}