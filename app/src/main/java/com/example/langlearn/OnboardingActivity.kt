package com.example.langlearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import me.relex.circleindicator.CircleIndicator

class OnboardingActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>
    lateinit var textList: List<String>
    lateinit var headerList: List<String>
    lateinit var buttonList: List<String>
    lateinit var indicator: CircleIndicator
    lateinit var viewText: TextView
    lateinit var button: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor
    var initScreen: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sharedPreferences = this@OnboardingActivity.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        initScreen = sharedPreferences.getInt("screenId", 0)
        print(initScreen)
        setContentView(R.layout.activity_onboarding)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //    insets
        //}
        viewPager = findViewById(R.id.idViewPager)
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.onboarding_1
        imageList = imageList + R.drawable.onboarding_2
        imageList = imageList + R.drawable.onboarding_3
        textList = ArrayList<String>()
        textList = textList + getString(R.string.onboardingText1)
        textList = textList + getString(R.string.onboardingText2)
        textList = textList + getString(R.string.onboardingText3)
        headerList = ArrayList<String>()
        headerList = headerList + getString(R.string.onboardingHeader1)
        headerList = headerList + getString(R.string.onboardingHeader2)
        headerList = headerList + getString(R.string.onboardingHeader3)
        buttonList = ArrayList<String>()
        buttonList = buttonList + getString(R.string.onboardingButtonText1)
        buttonList = buttonList + getString(R.string.onboardingButtonText2)
        buttonList = buttonList + getString(R.string.onboardingButtonText3)
        indicator = findViewById(R.id.indicator) as CircleIndicator

        viewPagerAdapter = ViewPagerAdapter(this@OnboardingActivity, imageList,headerList,textList)

        // on below line we are setting
        // adapter to our view pager.
        viewPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver())
        viewPager.adapter = viewPagerAdapter
        indicator.setViewPager(viewPager)
        viewText = findViewById(R.id.skipText)
        viewText.text = getString(R.string.onboardingSkip)
        button = findViewById(R.id.button) as Button
        button.text = buttonList.get(initScreen)
        viewPager.setCurrentItem(initScreen)
        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                button.text = buttonList.get(position)
                editor.putInt("screenId", position)
                editor.apply()
            }

        })
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val pos = viewPager.currentItem + 1
                if (pos < 3) {
                    viewPager.setCurrentItem(pos)
                    editor.putInt("screenId", pos)
                    editor.apply()
                }
                else {
                    val intent = Intent(this@OnboardingActivity,LanguageSelectorActivity::class.java)
                    editor.putInt("screenId", -1)
                    editor.apply()
                    startActivity(intent)
                    finish()

                }

            }
        })
        viewText.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@OnboardingActivity,LanguageSelectorActivity::class.java)
                editor.putInt("screenId", -1)
                editor.apply()
                startActivity(intent)
                finish()
            }
        })

    }

}