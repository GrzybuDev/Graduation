package com.example.lendall.page.user

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lendall.R
import kotlinx.android.synthetic.main.activity_us_show_page.*

class UsShowPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_us_show_page)

        UsShowAcceptButton.setOnClickListener {
           val intent: Intent = Intent(applicationContext, UsPage::class.java)
           startActivity(intent)
       }
    }

    override fun onResume() {
        super.onResume()
        UsShowFirstnameEdit.setText(intent.getCharSequenceExtra("us_Fname_show"))
        UsShowLastnameEdit.setText(intent.getCharSequenceExtra("us_Lname_show"))
        UsShowAddressEdit.setText(intent.getCharSequenceExtra("us_adres_show"))
        UsShowEmailEdit.setText(intent.getCharSequenceExtra("us_email_show"))
        UsShowTelEdit.setText(intent.getCharSequenceExtra("us_tel_show"))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent: Intent = Intent(applicationContext, UsPage::class.java)
        startActivity(intent)
    }
}


