package com.example.langlearn

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import me.relex.circleindicator.CircleIndicator

class OnboardingActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>
    lateinit var indicator: CircleIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
        val mLayoutInflater =
            this@OnboardingActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // on below line we are inflating our custom
        // layout file which we have created.
        val itemView: View = mLayoutInflater.inflate(R.layout.onboarding_slider_item, null)

        // on below line we are initializing
        // our image view with the id.

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPagerAdapter = ViewPagerAdapter(this@OnboardingActivity, imageList)
        // on below line we are setting
        // adapter to our view pager.
        viewPager.adapter = viewPagerAdapter
    }

}