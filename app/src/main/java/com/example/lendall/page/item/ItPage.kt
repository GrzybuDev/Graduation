package com.example.lendall.page.item

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lendall.R
import com.example.lendall.adapters.ItemAdapter
import com.example.lendall.page.MainActivity
import com.example.lendall.room.item.Item
import com.example.lendall.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_it_page.*

class ItPage : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listItem: LiveData<List<Item>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_it_page)

        viewModel = ViewModelProvider.AndroidViewModelFactory
            .getInstance(application)
            .create(ItemViewModel::class.java)
        recyclerView = findViewById(R.id.ItPageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        listItem = viewModel.getAllItem()
        listItem.observe(this, Observer {
            if (it.isNotEmpty()) {
                itemAdapter = ItemAdapter(it)
                recyclerView.adapter = itemAdapter
            }
        })
        ItPageAddButton.setOnClickListener {
            val intent: Intent = Intent(applicationContext, ItAddPage::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent: Intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}








