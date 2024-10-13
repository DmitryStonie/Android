package com.example.lab4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce


class MainActivity : AppCompatActivity() {
    companion object {
        val RIGHT_ANSWERS = arrayOf("Владимир", "владимир", "Vladimir", "vladimir")
        const val RIGHT_ANSWER_MESSAGE = "Правильно!"
        const val WRONG_ANSWER_MESSAGE = "Неправильно!"
        const val ANIMATION_START_VALUE = -40F
        const val ANIMATION_FINAL_POSITION = 0F
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button)
            .setOnClickListener {
                val editText = findViewById<EditText>(R.id.editTextText)
                if (editText.text.toString() in RIGHT_ANSWERS) {
                    val toast =
                        Toast.makeText(applicationContext, RIGHT_ANSWER_MESSAGE, Toast.LENGTH_SHORT)
                    toast.show()
                } else {
                    val springAnim = findViewById<View>(R.id.editTextText).let { img ->
                        SpringAnimation(
                            img,
                            DynamicAnimation.TRANSLATION_X,
                            ANIMATION_FINAL_POSITION
                        ).apply {
                            spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
                            spring.stiffness = SpringForce.STIFFNESS_LOW
                        }
                    }
                    springAnim.setStartValue(ANIMATION_START_VALUE)
                    springAnim.start()
                    val toast =
                        Toast.makeText(applicationContext, WRONG_ANSWER_MESSAGE, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }

    }

}