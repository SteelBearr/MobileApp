package com.example.langlearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class AuditionIncorrectActivity : AppCompatActivity() {
    lateinit var button: ImageButton
    lateinit var back: ImageView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var wordView: TextView
    lateinit var pronunciationView: TextView
    lateinit var textView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sharedPreferences = this@AuditionIncorrectActivity.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        setContentView(R.layout.activity_audition_incorrect)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        wordView = findViewById(R.id.textWord) as TextView
        pronunciationView = findViewById(R.id.textPronunciation) as TextView
        textView = findViewById(R.id.editTextPronunciation) as EditText
        wordView.text = sharedPreferences.getString("lastWord","")
        pronunciationView.text = sharedPreferences.getString("lastPronunciation","")
        textView.setText(sharedPreferences.getString("lastWord","")?.drop(Random.nextInt(from = 1, until = (sharedPreferences.getString("lastWord","")).toString().length)))
        back = findViewById(R.id.back) as ImageView
        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@AuditionIncorrectActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        button = findViewById(R.id.buttonRetry) as ImageButton
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@AuditionIncorrectActivity, AuditionActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}