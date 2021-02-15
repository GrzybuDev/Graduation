package com.example.lendall.page.item

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lendall.R
import com.example.lendall.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_it_del_page.*

class ItDelPage : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_it_del_page)

        val DeleteItToast = Toast.makeText(applicationContext,"Usunięto przedmiot!",Toast.LENGTH_SHORT)
        viewModel = ViewModelProvider.AndroidViewModelFactory
            .getInstance(application)
            .create(ItemViewModel::class.java)
        ItDelYesButton.setOnClickListener {
            viewModel.deleteRow(intent.getCharSequenceExtra("it_name_delete") as String,
                    intent.getCharSequenceExtra("it_des_delete") as String,
                    intent.getCharSequenceExtra("it_ace_delete") as String)
            var intent: Intent = Intent(applicationContext, ItPage::class.java)
            startActivity(intent)
            DeleteItToast.show()
        }
        ItDelNoButton.setOnClickListener {
            var intent: Intent = Intent(applicationContext, ItPage::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        ItDelNameIt.setText(intent.getCharSequenceExtra("it_name_delete"))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent: Intent = Intent(applicationContext, ItPage::class.java)
        startActivity(intent)
    }
}

//  var item = Item(intent.getCharSequenceExtra("it_name_delete") as String, intent.getCharSequenceExtra("it_des_delete") as String, intent.getCharSequenceExtra("it_ace_delete") as String)

