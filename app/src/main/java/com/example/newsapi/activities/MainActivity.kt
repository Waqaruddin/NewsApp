package com.example.newsapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.newsapi.R
import com.example.newsapi.adpaters.AdapterNews
import com.example.newsapi.models.Article
import com.example.newsapi.models.NewsResult
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mList:ArrayList<Article> = ArrayList()
    var adapterNews: AdapterNews?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        getData()
         adapterNews = AdapterNews(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterNews
    }

    private fun getData() {
        var url = "http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a1c63f6fa6a645088799c895f54f5ed6"
        var requestQueue = Volley.newRequestQueue(this)
        var request = StringRequest(
            Request.Method.GET,
            url,
            {
                var gson = Gson()
                var newsResult = gson.fromJson(it, NewsResult::class.java)
                mList.addAll(newsResult.articles)
                adapterNews?.setData(mList)
                progress_bar.visibility = View.GONE


            },
            {


            }
        )
        requestQueue.add(request)

    }
}