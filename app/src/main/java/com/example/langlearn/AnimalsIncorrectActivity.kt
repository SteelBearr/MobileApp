package com.example.langlearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnimalsIncorrectActivity : AppCompatActivity() {
    lateinit var buttonNext: Button
    lateinit var buttonAgain: Button
    lateinit var back: ImageView
    lateinit var answer: TextView
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sharedPreferences = this@AnimalsIncorrectActivity.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        setContentView(R.layout.activity_animals_incorrect)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        answer = findViewById(R.id.textAnswer) as TextView
        answer.text = answer.text.toString() + sharedPreferences.getString("lastAnimal","")
        back = findViewById(R.id.back) as ImageView
        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@AnimalsIncorrectActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        buttonNext = findViewById(R.id.buttonNext) as Button
        buttonNext.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@AnimalsIncorrectActivity,AnimalsActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        buttonAgain = findViewById(R.id.buttonTryAgain) as Button
        buttonAgain.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@AnimalsIncorrectActivity,AnimalsActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

    }
}