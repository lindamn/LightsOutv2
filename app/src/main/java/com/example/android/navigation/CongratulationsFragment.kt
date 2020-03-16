package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.penaranda_exer5_lightsoutv2.R
import com.example.penaranda_exer5_lightsoutv2.databinding.FragmentCongratulationsBinding

/**
 * A simple [Fragment] subclass.
 */
class CongratulationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCongratulationsBinding>(inflater,
            R.layout.fragment_congratulations,container,false)
        val args = CongratulationsFragmentArgs.fromBundle(arguments!!)

        binding.congratulationsMessage.text =
            """You finished the game in ${args.noOfMoves} moves!"""

        return binding.root
    }

}
