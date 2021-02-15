package com.example.lendall.page.item

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lendall.R
import com.example.lendall.room.item.Item
import com.example.lendall.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_it_add_page.*

class ItAddPage : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_it_add_page)

        viewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(application)
                .create(ItemViewModel::class.java)

        ItAddAcceptButton.setOnClickListener {
            val ItAddNameEdit = ItAddNameEdit.text.toString()
            val ItAddDesEdit = ItAddDesEdit.text.toString()
            val item = Item(ItAddNameEdit, ItAddDesEdit, "Dostępne")
            viewModel.insertItem(item)

            var intent: Intent = Intent(applicationContext, ItPage::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent: Intent = Intent(applicationContext, ItPage::class.java)
        startActivity(intent)
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

