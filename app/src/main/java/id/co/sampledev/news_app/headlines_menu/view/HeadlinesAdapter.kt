package id.co.sampledev.news_app.headlines_menu.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.sampledev.news_app.R
import id.co.sampledev.news_app.article_detail.view.ArticleDetailActivity
import id.co.sampledev.news_app.network.model.ArticlesItem

class HeadlinesAdapter(private val newsList: List<ArticlesItem>) : RecyclerView.Adapter<HeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return HeadlinesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeadlinesViewHolder, position: Int) {
        val news = newsList[position]
        holder.title_tv.text = news.title
        holder.author_tv.text = news.author
        holder.date_tv.text = news.publishedAt
        holder.detail_btn.setOnClickListener {
            val intent = Intent(holder.itemView.context, ArticleDetailActivity::class.java)
            intent.putExtra("news_title", news.title)
            intent.putExtra("author", news.author)
            intent.putExtra("publish_date", news.publishedAt)
            intent.putExtra("url", news.url)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}