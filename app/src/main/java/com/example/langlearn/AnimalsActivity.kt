package com.example.langlearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso
import kotlin.random.Random

class AnimalsActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var back: ImageView
    lateinit var animalImages: List<Int>
    lateinit var animalStrings: List<String>
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sharedPreferences = this@AnimalsActivity.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        setContentView(R.layout.activity_animals)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        animalImages = ArrayList<Int>()
        animalImages = animalImages + R.drawable.animal_1
        animalImages = animalImages + R.drawable.animal_2
        animalImages = animalImages + R.drawable.animal_3
        animalStrings = ArrayList<String>()
        animalStrings = animalStrings + "Bear"
        animalStrings = animalStrings + "Dog"
        animalStrings = animalStrings + "Cat"
        val number: Int = Random.nextInt(from = 0, until = 3)
        editor.putString("lastAnimal", animalStrings.get(number))
        editor.apply()
        imageView = findViewById(R.id.animalImage)
        val transformation: com.squareup.picasso.Transformation = RoundedTransformationBuilder()
            .cornerRadiusDp(20f)
            .oval(false)
            .build()

        Picasso.get()
            .load(animalImages.get(number))
            .fit()
            .transform(transformation)
            .into(imageView)
        back = findViewById(R.id.back) as ImageView
        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@AnimalsActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        button = findViewById(R.id.buttonCheck) as Button
        editText = findViewById(R.id.editTextAnimal) as EditText
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (editText.text.toString().lowercase() == animalStrings.get(number).lowercase()){
                    val intent = Intent(this@AnimalsActivity,AnimalsCorrectActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    val intent = Intent(this@AnimalsActivity,AnimalsIncorrectActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })

    }
}