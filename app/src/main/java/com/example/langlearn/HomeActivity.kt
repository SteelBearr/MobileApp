package com.example.langlearn


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso


class HomeActivity : AppCompatActivity() {
    lateinit var profileImageView: ImageView
    lateinit var buttonAnimals: ImageButton
    lateinit var buttonAudition: ImageButton
    lateinit var buttonWords: ImageButton
    lateinit var buttonGame: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        profileImageView = findViewById(R.id.profile_image) as ImageView
        profileImageView.setImageResource(R.drawable.avatar)
        val transformation: com.squareup.picasso.Transformation = RoundedTransformationBuilder()
            .cornerRadiusDp(100f)
            .oval(false)
            .build()

        Picasso.get()
            .load(R.drawable.avatar)
            .fit()
            .transform(transformation)
            .into(profileImageView)

        profileImageView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    val intent = Intent(this@HomeActivity,ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                }
        })
        buttonAnimals = findViewById(R.id.buttonAnimal) as ImageButton
        buttonAnimals.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@HomeActivity,AnimalsActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        buttonAudition = findViewById(R.id.buttonAudition) as ImageButton
        buttonAudition.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@HomeActivity,AuditionActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        buttonWords = findViewById(R.id.buttonWords) as ImageButton
        buttonWords.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@HomeActivity,WordsActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        buttonGame = findViewById(R.id.buttonGame) as ImageButton
        buttonGame.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@HomeActivity,GameActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}