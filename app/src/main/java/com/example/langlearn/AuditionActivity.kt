package com.example.langlearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class AuditionActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var back: ImageView
    lateinit var wordStrings: List<String>
    lateinit var pronunciationStrings: List<String>
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var wordView: TextView
    lateinit var pronunciationView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sharedPreferences = this@AuditionActivity.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        setContentView(R.layout.activity_audition)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        wordStrings = ArrayList<String>()
        wordStrings = wordStrings + "cucumber"
        wordStrings = wordStrings + "pronunciation"
        wordStrings = wordStrings + "simultaneously"

        pronunciationStrings = ArrayList<String>()
        pronunciationStrings = pronunciationStrings + "['kju:kʌmbə]"
        pronunciationStrings = pronunciationStrings + "[prə'nʌnsɪ'eɪʃ(ə)n]"
        pronunciationStrings = pronunciationStrings + "[sɪm(ə)l'teɪnɪəslɪ]"
        val number: Int = Random.nextInt(from = 0, until = 3)
        editor.putString("lastWord", wordStrings.get(number))
        editor.putString("lastPronunciation", pronunciationStrings.get(number))
        editor.apply()
        wordView = findViewById(R.id.textWord) as TextView
        pronunciationView = findViewById(R.id.textPronunciation) as TextView
        wordView.text = wordStrings.get(number)
        pronunciationView.text = pronunciationStrings.get(number)
        back = findViewById(R.id.back) as ImageView
        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@AuditionActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        })


        button = findViewById(R.id.buttonCheck) as Button
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (Random.nextInt(from = 0, until = 2) == 0) {
                    val intent = Intent(this@AuditionActivity, AuditionCorrectActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    val intent = Intent(this@AuditionActivity, AuditionIncorrectActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })
    }
}