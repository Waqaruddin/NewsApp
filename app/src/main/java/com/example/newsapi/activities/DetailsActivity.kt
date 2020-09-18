package com.example.newsapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapi.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var title = intent.getStringExtra("TITLE")
        text_view_title.text = title
    }
}