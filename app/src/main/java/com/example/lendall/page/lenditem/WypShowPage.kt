package com.example.lendall.page.lenditem

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lendall.R
import kotlinx.android.synthetic.main.activity_wyp_show_page.*

class WypShowPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wyp_show_page)

        WypUsShowAcceptButton.setOnClickListener {
            val intent: Intent = Intent(applicationContext, WypPage::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        WypUsShowFirstnameEdit.setText(intent.getCharSequenceExtra("wyp_us_Fname_show"))
        WypUsShowLastnameEdit.setText(intent.getCharSequenceExtra("wyp_us_Lname_show"))
        WypUsShowAddressEdit.setText(intent.getCharSequenceExtra("wyp_us_adres_show"))
        WypUsShowEmailEdit.setText(intent.getCharSequenceExtra("wyp_us_email_show"))
        WypUsShowTelEdit.setText(intent.getCharSequenceExtra("wyp_us_tel_show"))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var aktywnosc: Intent = Intent(applicationContext, WypPage::class.java)
        startActivity(aktywnosc)
    }
}



