package com.example.lendall.page.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lendall.R
import com.example.lendall.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_us_edit_page.*

class UsEditPage : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_us_edit_page)

        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(UserViewModel::class.java)

        UsEditAcceptButton.setOnClickListener {
            val UsEditFirstnameEdit = UsEditFirstnameEdit.text.toString()
            val UsEditLastnameEdit = UsEditLastnameEdit.text.toString()
            val UsEditAddressEdit = UsEditAddressEdit.text.toString()
            val UsEditEmailEdit = UsEditEmailEdit.text.toString()
            val UsEditTelEdit = UsEditTelEdit.text.toString()
        viewModel.editRowUser(UsEditFirstnameEdit,UsEditLastnameEdit,UsEditAddressEdit
                ,UsEditEmailEdit,UsEditTelEdit,intent.getCharSequenceExtra("us_adres_edit") as String
                ,intent.getCharSequenceExtra("us_email_edit") as String
                ,intent.getCharSequenceExtra("us_tel_edit") as String)
        val intent: Intent = Intent(applicationContext, UsPage::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        UsEditFirstnameEdit.setText(intent.getCharSequenceExtra("us_Fname_edit"))
        UsEditLastnameEdit.setText(intent.getCharSequenceExtra("us_Lname_edit"))
        UsEditAddressEdit.setText(intent.getCharSequenceExtra("us_adres_edit"))
        UsEditEmailEdit.setText(intent.getCharSequenceExtra("us_email_edit"))
        UsEditTelEdit.setText(intent.getCharSequenceExtra("us_tel_edit"))
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent: Intent = Intent(applicationContext, UsPage::class.java)
        startActivity(intent)
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}

