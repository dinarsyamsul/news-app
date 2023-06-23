package id.co.sampledev.news_app.headlines_menu.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.co.sampledev.news_app.R
import id.co.sampledev.news_app.network.model.ArticlesItem

class HeadlinesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title_tv: TextView = itemView.findViewById(R.id.news_title)
    val author_tv: TextView = itemView.findViewById(R.id.author)
    val date_tv: TextView = itemView.findViewById(R.id.publish_date)
    val detail_btn: Button = itemView.findViewById(R.id.see_detail)
}