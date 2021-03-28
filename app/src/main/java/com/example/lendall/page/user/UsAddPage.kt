package com.example.lendall.page.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lendall.ObslugaEmail
import com.example.lendall.R
import com.example.lendall.room.user.User
import com.example.lendall.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_us_add_page.*

class UsAddPage : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_us_add_page)
        viewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(application)
                .create(UserViewModel::class.java)
        UsAddAcceptButton.setOnClickListener {
            val UsAddFirstnameEdit = UsAddFirstnameEdit.text.toString()
            val UsAddLastnameEdit = UsAddLastnameEdit.text.toString()
            val UsAddAddressEdit = UsAddAddressEdit.text.toString()
            val UsAddEmailEdit = UsAddEmailEdit.text.toString()
            val UsAddTelEdit = UsAddTelEdit.text.toString()
            val user = User(UsAddFirstnameEdit,UsAddLastnameEdit,UsAddAddressEdit,UsAddEmailEdit,UsAddTelEdit)
            viewModel.insertUsers(user)
            val intent: Intent = Intent(applicationContext, UsPage::class.java)
            startActivity(intent)
        }
        ObslugaEmail(UsAddEmailEdit,UsAddEmailText)
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



/*
        val UsAddEmailEdit: EditText = findViewById(R.id.UsAddEmailEdit)
        val UsAddEmailText: TextView = findViewById(R.id.UsAddEmailText)

        val UsAddFirstnameEdit: EditText = findViewById(R.id.UsAddFirstnameEdit)

        val UsAddAddressEdit: EditText = findViewById(R.id.UsAddAddressEdit)

        val UsAddLastnameEdit: EditText = findViewById(R.id.UsAddLastnameEdit)

        val UsAddTelEdit: EditText = findViewById(R.id.UsAddTelEdit)

        val UsAddAcceptButton: Button = findViewById(R.id.UsAddAcceptButton)
*/

/*
    override fun onUserInteraction() {
        super.onUserInteraction()

        val UsAddEmailEdit: TextView = findViewById(R.id.UsAddEmailEdit)
        val UsAddEmailAlert: TextView = findViewById(R.id.UsAddEmailAlert)

        if(UsAddEmailEdit.isFocused)
        {
            UsAddEmailAlert.setText("Niepoprawny e-mail")
            for(i in UsAddEmailEdit.text)
            {
                if(i == '@')
                {
                    UsAddEmailAlert.setText("Poprwany e-mail")
                    UsAddEmailAlert.visibility = TextView.VISIBLE
                }
                else
                {
                    UsAddEmailAlert.visibility = TextView.VISIBLE
                }
            }
        }
        else
        {
            UsAddEmailAlert.visibility = TextView.INVISIBLE
        }
    }

 */
