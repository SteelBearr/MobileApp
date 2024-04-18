package com.example.langlearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class LanguageSelectorActivity : AppCompatActivity() {
    lateinit var viewRecycleAdapter: RecycleViewAdapter
    lateinit var viewRecycle: RecyclerView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language_selector)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val itemList = ArrayList<RecycleItem>()
        itemList.add(RecycleItem("English",true))
        itemList.add(RecycleItem("Russian"))
        itemList.add(RecycleItem("Chinese"))
        itemList.add(RecycleItem("Belarus"))
        itemList.add(RecycleItem("Kazakh"))

        viewRecycle = findViewById(R.id.recycleView) as RecyclerView
        viewRecycle.layoutManager = LinearLayoutManager(this)
        viewRecycleAdapter = RecycleViewAdapter(itemList) { position ->
            itemList.forEachIndexed { index, item ->
                item.isSelectActivity = index == position
            }
            viewRecycle.adapter?.notifyDataSetChanged()
        }
        viewRecycle.adapter = viewRecycleAdapter
        button = findViewById(R.id.button2) as Button
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@LanguageSelectorActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }

}