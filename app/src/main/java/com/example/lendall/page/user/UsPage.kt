package com.example.lendall.page.user

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lendall.R
import com.example.lendall.adapters.UserAdapter
import com.example.lendall.page.MainActivity
import com.example.lendall.room.user.User
import com.example.lendall.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_us_page.*

class UsPage : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listUser: LiveData<List<User>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_us_page)

        viewModel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(application)
                .create(UserViewModel::class.java)
        recyclerView = findViewById(R.id.UsPageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        listUser = viewModel.getAllUser()
        listUser.observe(this, Observer {
            if(it.isNotEmpty()){
                userAdapter = UserAdapter(it)
                recyclerView.adapter = userAdapter
            }
        })
        UsPageAddButton.setOnClickListener{
            var intent: Intent = Intent(applicationContext, UsAddPage::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        var intent: Intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}


