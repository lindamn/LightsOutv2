package com.example.android.navigation

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.penaranda_exer5_lightsoutv2.R
import com.example.penaranda_exer5_lightsoutv2.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*
import android.view.ViewGroup as ViewGroup1

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup1?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        val args = GameFragmentArgs.fromBundle(arguments!!)

        binding.name.text = """Hello ${args.nameOfPlayer}! Enjoy the game!"""

        val lights : Array<Array<TextView>> = Array(5) {Array(5){binding.light00} }

        val lightsFlag : Array<BooleanArray> = Array(5) {BooleanArray(5) {false} }

        val light1 = binding.light00
        val light2 = binding.light01
        val light3 = binding.light02
        val light4 = binding.light03
        val light5 = binding.light04
        val light6 = binding.light10
        val light7 = binding.light11
        val light8 =  binding.light12
        val light9 = binding.light13
        val light10 = binding.light14
        val light11 = binding.light20
        val light12 = binding.light21
        val light13 = binding.light22
        val light14 = binding.light23
        val light15 = binding.light24
        val light16 = binding.light30
        val light17 = binding.light31
        val light18 = binding.light32
        val light19 = binding.light33
        val light20 = binding.light34
        val light21 = binding.light40
        val light22 = binding.light41
        val light23 = binding.light42
        val light24 = binding.light43
        val light25 = binding.light44

        lights[0][0] = light1
        lights[0][1] = light2
        lights[0][2] = light3
        lights[0][3] = light4
        lights[0][4] = light5
        lights[1][0] = light6
        lights[1][1] = light7
        lights[1][2] = light8
        lights[1][3] = light9
        lights[1][4] = light10
        lights[2][0] = light11
        lights[2][1] = light12
        lights[2][2] = light13
        lights[2][3] = light14
        lights[2][4] = light15
        lights[3][0] = light16
        lights[3][1] = light17
        lights[3][2] = light18
        lights[3][3] = light19
        lights[3][4] = light20
        lights[4][0] = light21
        lights[4][1] = light22
        lights[4][2] = light23
        lights[4][3] = light24
        lights[4][4] = light25

        binding.resetButton.setOnClickListener{

            for(i in 0..4){
                for(j in 0..4){
                    (lights[i][j]).setBackgroundColor(Color.GRAY)
                    lightsFlag[i][j] = false
                }
            }
            val temp = 0
            binding.noOfMoves.text = temp.toString()

        }

        val clickableViews: List<TextView> =
            listOf(light1, light2, light3, light4, light5,
                light6, light7, light8, light9, light10,
                light11, light12, light13, light14, light15,
                light16, light17, light18, light19, light20,
                light21, light22, light23, light24, light25)

        for(item in clickableViews){
            item.setOnClickListener{
                val moveCount: TextView = binding.noOfMoves

                for (i in 0..4) {
                    for (j in 0..4) {
                        if (item == lights[i][j]) {

                            if (lightsFlag[i][j] == false) {
                                item.setBackgroundColor(Color.RED)
                                lightsFlag[i][j] = true
                            } else {
                                item.setBackgroundColor(Color.GRAY)
                                lightsFlag[i][j] = false
                            }
                            //changes color of the lower box (if there is lower box)
                            if (i in 0..3) {
                                if (lightsFlag[i + 1][j] == false) {
                                    (lights[i + 1][j]).setBackgroundColor(
                                        Color.RED
                                    )
                                    lightsFlag[i + 1][j] = true
                                } else {
                                    (lights[i + 1][j]).setBackgroundColor(
                                        Color.GRAY
                                    )
                                    lightsFlag[i + 1][j] = false
                                }
                            }
                            //changes color of the upper box
                            if (i in 1..4) {
                                if (lightsFlag[i - 1][j] == false) {
                                    (lights[i - 1][j]).setBackgroundColor(
                                        Color.RED
                                    )
                                    lightsFlag[i - 1][j] = true
                                } else {
                                    (lights[i - 1][j]).setBackgroundColor(
                                        Color.GRAY
                                    )
                                    lightsFlag[i - 1][j] = false
                                }
                            }
                            //changes the color of the right box
                            if (j in 0..3) {
                                if (lightsFlag[i][j + 1] == false) {
                                    (lights[i][j + 1]).setBackgroundColor(
                                        Color.RED
                                    )
                                    lightsFlag[i][j + 1] = true
                                } else {
                                    (lights[i][j + 1]).setBackgroundColor(
                                        Color.GRAY
                                    )
                                    lightsFlag[i][j + 1] = false
                                }
                            }
                            //changes the color of the left box
                            if (j in 1..4) {
                                if (lightsFlag[i][j - 1] == false) {
                                    (lights[i][j - 1]).setBackgroundColor(
                                        Color.RED
                                    )
                                    lightsFlag[i][j - 1] = true
                                } else {
                                    (lights[i][j - 1]).setBackgroundColor(
                                        Color.GRAY
                                    )
                                    lightsFlag[i][j - 1] = false
                                }
                            }
                        }
                    }
                }
                var temp : Int = moveCount.text.toString().toInt()
                temp += 1
                moveCount.text = temp.toString()

                //checks if all lights are lit

                for(i in 0..4){
                    for(j in 0..4){
                        if(lightsFlag[i][j] == false){
                            return@setOnClickListener
                        }
                    }
                }

                it.findNavController().navigate(GameFragmentDirections.actionGameFragmentToCongratulationsFragment(moveCount.text.toString().toInt()))
            }

        }
        return binding.root
    }

}