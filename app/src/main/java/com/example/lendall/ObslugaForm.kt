package com.example.lendall

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

fun ObslugaEmail(UsAddEmailEdit: EditText, UsAddEmailText: TextView){
    UsAddEmailEdit.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?)
        {
            if(UsAddEmailEdit.length() == 0) UsAddEmailText.setText(R.string.adduseremail)
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            UsAddEmailText.setText("Niepoprawny e-mail")
            for(i:Char in UsAddEmailEdit.text){
                if(i == '@'){
                    UsAddEmailText.setText("Poprawny e-mail")
                }
            }
        }
    })
}



    //UsAddEmailAlert.visibility = TextView.VISIBLE
    /*UsAddEmailEdit.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?)
        {
            if(UsAddEmailEdit.length() == 0) UsAddEmailAlert.visibility = TextView.VISIBLE
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            UsAddEmailAlert.setText("Niepoprawny e-mail")
            for(i:Char in UsAddEmailEdit.text){
                if(i == '@'){
                    UsAddEmailAlert.setText("Poprawny e-mail")
                    UsAddEmailAlert.visibility = TextView.VISIBLE
                }
            }
            UsAddEmailAlert.visibility = TextView.VISIBLE
        }
    })

     */
