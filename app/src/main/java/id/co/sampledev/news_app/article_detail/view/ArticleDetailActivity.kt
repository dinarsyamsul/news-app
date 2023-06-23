package id.co.sampledev.news_app.article_detail.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.co.sampledev.news_app.R

class ArticleDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val newsTitle = intent.getStringExtra("news_title")
        val author = intent.getStringExtra("author")
        val publishDate = intent.getStringExtra("publish_date")
        val url = intent.getStringExtra("url")

        val newsTitleTextView: TextView = findViewById(R.id.news_title)
        val authorPublishDateTextView: TextView = findViewById(R.id.author_publish_date)
        val urlTextView: TextView = findViewById(R.id.url)

        newsTitleTextView.text = newsTitle
        authorPublishDateTextView.text = "$author | $publishDate"
        urlTextView.text = url
    }
}