package com.example.lendall.page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lendall.R
import com.example.lendall.page.item.ItPage
import com.example.lendall.page.lenditem.WypPage
import com.example.lendall.page.user.UsPage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wyp_button: Button = findViewById(R.id.wyp_button)
        val zwr_button: Button = findViewById(R.id.zwr_button)
        val it_button: Button = findViewById(R.id.it_button)
        val us_button: Button = findViewById(R.id.us_button)
        wyp_button.setOnClickListener {
            val intent: Intent = Intent(applicationContext, WypPage::class.java)
            startActivity(intent)
        }
        zwr_button.setOnClickListener {
            val intent: Intent = Intent(applicationContext, ZwrPage::class.java)
            startActivity(intent)
        }
        it_button.setOnClickListener {
            val intent: Intent = Intent(applicationContext, ItPage::class.java)
            startActivity(intent)
        }
        us_button.setOnClickListener {
            val intent: Intent = Intent(applicationContext, UsPage::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish();
        System.exit(0);
    }
}


