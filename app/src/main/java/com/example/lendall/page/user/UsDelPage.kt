package com.example.lendall.page.user

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lendall.R
import com.example.lendall.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_us_del_page.*

class UsDelPage : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_us_del_page)

        val DeleteUsToast = Toast.makeText(applicationContext, "Usunięto użytkownika!",Toast.LENGTH_SHORT)
        viewModel = ViewModelProvider.AndroidViewModelFactory
            .getInstance(application)
            .create(UserViewModel::class.java)

        UsDelYesButton.setOnClickListener {
            viewModel.deleteRowUser(intent.getCharSequenceExtra("us_email_del") as String, intent.getCharSequenceExtra("us_tel_del") as String)
            val intent: Intent = Intent(applicationContext, UsPage::class.java)
            startActivity(intent)
            DeleteUsToast.show()
        }
        UsDelNoButton.setOnClickListener {
            val intent: Intent = Intent(applicationContext, UsPage::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        UsDelFirstname.setText(intent.getCharSequenceExtra("us_Fname_del"))
        UsDelLastname.setText(intent.getCharSequenceExtra("us_Lname_del"))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent: Intent = Intent(applicationContext, UsPage::class.java)
        startActivity(intent)
    }
}


