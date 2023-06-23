package id.co.sampledev.news_app.headlines_menu.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import id.co.sampledev.news_app.R
import id.co.sampledev.news_app.headlines_menu.viewmodel.HeadlinesViewModel

class HeadlinesActivity : AppCompatActivity() {

private lateinit var headlinesVM: HeadlinesViewModel
private lateinit var recyclerView: RecyclerView
private lateinit var adapter: HeadlinesAdapter
private lateinit var headlinesLoading: CircularProgressIndicator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headline)

        recyclerView = findViewById(R.id.headline_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        headlinesVM = ViewModelProvider(this)[HeadlinesViewModel::class.java]
        headlinesVM.getHeadlines()

        headlinesLoading = findViewById(R.id.headlines_content_loading)

        observeHeadlines()
    }

    private fun observeHeadlines() {
        headlinesVM.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                headlinesLoading.visibility = View.VISIBLE // Show loading animation
            } else {
                headlinesLoading.visibility = View.GONE // Hide loading animation
            }
        }

        headlinesVM.headlines.observe(this) { headlines ->
            adapter = HeadlinesAdapter(headlines?.articles ?: emptyList())
            recyclerView.adapter = adapter
        }
    }

}