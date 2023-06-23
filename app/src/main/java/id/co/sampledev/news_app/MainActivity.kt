package id.co.sampledev.news_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import id.co.sampledev.news_app.headlines_menu.view.HeadlinesActivity
import id.co.sampledev.news_app.headlines_menu.viewmodel.HeadlinesViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seeHeadlinesBtn = findViewById<Button>(R.id.see_headline_btn)
        seeHeadlinesBtn.setOnClickListener {
            val intent = Intent(this, HeadlinesActivity::class.java)
            startActivity(intent)
        }
    }
}