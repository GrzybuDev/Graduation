package com.example.lendall.page.lenditem

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lendall.R
import com.example.lendall.adapters.WypUserAdapter
import com.example.lendall.page.MainActivity
import com.example.lendall.room.user.User
import com.example.lendall.viewmodel.UserViewModel

class WypPage : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userViewModel: UserViewModel
    private lateinit var listUser: LiveData<List<User>>
    private lateinit var wypuserAdapter: WypUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wyp_page)

        userViewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(application)
                .create(UserViewModel::class.java)
        recyclerView = findViewById(R.id.WypRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        listUser = userViewModel.getAllUser()
        listUser.observe(this, Observer {
            if (it.isNotEmpty()){
                wypuserAdapter = WypUserAdapter(it)
                recyclerView.adapter = wypuserAdapter
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent: Intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}



/*
        option = findViewById(R.id.WypSpinner) as Spinner
        result = findViewById(R.id.WypTextSpinner) as TextView

       listUser = userViewModel.getAllUser()
        val options = arrayOf("Option 1", "Option 2", "Option 3")
        val layoutInflater = LayoutInflater.from(applicationContext)
        val options = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)


        option.adapter = ArrayAdapter<List<User>>(this,android.R.layout.simple_list_item_1,options)
        option.adapter = userAdapter

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please select an option"
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
              //  result.text = options.get(position).toString()
            }



        }*/

