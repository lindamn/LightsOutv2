package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.penaranda_exer5_lightsoutv2.R
import com.example.penaranda_exer5_lightsoutv2.databinding.FragmentStartBinding
import kotlinx.android.synthetic.main.fragment_start.*

/**
 * A simple [Fragment] subclass.
 */
class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentStartBinding>(inflater,
            R.layout.fragment_start,container,false)
        binding.enterGameButton.setOnClickListener { view : View ->
            view.findNavController().navigate(StartFragmentDirections.actionStartFragmentToGameFragment(binding.nameField.text.toString()))
        }
        return binding.root
    }

}
