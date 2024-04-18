package com.example.langlearn

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var themeButton: Button
    lateinit var languageButton: Button
    lateinit var imageButton: Button
    lateinit var logoutButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageView = findViewById(R.id.profile_image) as ImageView
        imageView.setImageResource(R.drawable.avatar)
        val transformation: com.squareup.picasso.Transformation = RoundedTransformationBuilder()
            .cornerRadiusDp(100f)
            .oval(false)
            .build()

        Picasso.get()
            .load(R.drawable.avatar)
            .fit()
            .transform(transformation)
            .into(imageView)
        themeButton = findViewById(R.id.themeButton) as Button
        val isDarkTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        themeButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (isDarkTheme) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                val intent = Intent(this@ProfileActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        languageButton = findViewById(R.id.languageButton) as Button
        languageButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@ProfileActivity,LanguageSelectorActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        imageButton = findViewById(R.id.imageButton) as Button
        logoutButton = findViewById(R.id.logoutButton) as Button
        logoutButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@ProfileActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        imageButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@ProfileActivity,ChangePhotoActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

    }
}