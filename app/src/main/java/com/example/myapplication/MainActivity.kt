package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.Random

private val ROLL_DURATION = 5000L
private val ROLL_INTERVAL = 300L

private lateinit var binding:ActivityMainBinding

private val dices= listOf(
    R.drawable.empty_dice,
    R.drawable.dice_1,
    R.drawable.dice_2,
    R.drawable.dice_3,
    R.drawable.dice_4,
    R.drawable.dice_5,
    R.drawable.dice_6
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.button.setOnClickListener {
            diceroll()
        }
    }

    private fun diceroll(){
        val countDownTimer = object:CountDownTimer(5000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                selectedDice()
            }
            override fun onFinish() {
                selectedDice()
            }
        }
        countDownTimer.start()
    }


    private fun selectedDice() {
        val diceNum = Random().nextInt(6) + 1
        val dice    = dices[diceNum]
        binding.imgDice.setImageResource(dice)
    }
}