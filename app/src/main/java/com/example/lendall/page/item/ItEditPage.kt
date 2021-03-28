package com.example.lendall.page.item

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lendall.R
import com.example.lendall.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_it_edit_page.*

class ItEditPage : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_it_edit_page)

        viewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(application)
                .create(ItemViewModel::class.java)

        ItEditAcceptButton.setOnClickListener {
            val ItEditNameEdit = ItEditNameEdit.text.toString()
            val ItEditDesEdit = ItEditDesEdit.text.toString()
            viewModel.editItem(ItEditNameEdit,ItEditDesEdit,
                    intent.getCharSequenceExtra("it_name_edit").toString(),
                    intent.getCharSequenceExtra("it_des_edit").toString())
            val intent: Intent = Intent(applicationContext, ItPage::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        ItEditNameEdit.setText(intent.getCharSequenceExtra("it_name_edit"))
        ItEditDesEdit.setText(intent.getCharSequenceExtra("it_des_edit"))
        ItEditAceEdit.setText(intent.getCharSequenceExtra("it_ace_edit"))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent: Intent = Intent(applicationContext, ItPage::class.java)
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


/*}
        var ItAddAcceptButton: Button = findViewById(R.id.ItAddAcceptButton)
        var ItAddNameEdit: EditText = findViewById(R.id.ItAddNameEdit)
        var ItAddDesEdit: EditText = findViewById(R.id.ItAddDesEdit)


        val dbHelper = DataBaseHelper(applicationContext)
        val db = dbHelper.writableDatabase

        val AcceptAddItToast = Toast.makeText(applicationContext,"Dodano przedmiot!",Toast.LENGTH_SHORT)

       ItAddAcceptButton.setOnClickListener {
           val it_name = ItAddNameEdit.text.toString()
           val it_des = ItAddDesEdit.text.toString()

           val value = ContentValues()
           value.put("it_name", it_name)
           value.put("it_des", it_des)

           db.insertOrThrow(TableIt.TABLE_NAME, null, value)

           AcceptAddItToast.show()

            var aktywnosc: Intent = Intent(applicationContext, ItPage::class.java)
            startActivity(aktywnosc)
        }
*/

