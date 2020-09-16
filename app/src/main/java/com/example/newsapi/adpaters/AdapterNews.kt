package com.example.newsapi.adpaters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.R
import com.example.newsapi.models.Article
import kotlinx.android.synthetic.main.row_news_adapter.view.*

class AdapterNews(var context: Context, var list:ArrayList<Article>): RecyclerView.Adapter<AdapterNews.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.row_news_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var article = list[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(l:ArrayList<Article>){
        list = l
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(article:Article){
            itemView.text_view_title.text = article.title
            itemView.text_view_author.text = article.author
        }

    }
}