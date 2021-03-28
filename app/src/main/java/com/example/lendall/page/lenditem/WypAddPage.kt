package com.example.lendall.page.lenditem
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.budiyev.android.codescanner.*
import com.example.lendall.R
import com.example.lendall.page.MainActivity
import com.example.lendall.viewmodel.ItemViewModel
import com.example.lendall.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_wyp_add_page.*
class WypAddPage : AppCompatActivity() {
    private lateinit var codeScanner: CodeScanner
    private lateinit var userViewModel: UserViewModel
    private lateinit var itemViewModel: ItemViewModel
    val MY_CAMERA_PERMISSION_REQUEST = 1111
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wyp_add_page)
        userViewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(application)
                .create(UserViewModel::class.java)
        codeScanner = CodeScanner(this, scanner_view)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                WypAddEditText.setText(it.text)
            }
        }
        codeScanner.errorCallback = ErrorCallback {
            runOnUiThread {
                Toast.makeText(this, "Błąd aparatu ${it.message}", Toast.LENGTH_LONG).show()
            }
        }
        checkPremission()
        WypAddAcceptButton.setOnClickListener {
            val WypAddEditText = WypAddEditText.text.toString()
            val WypAddFirstname = WypAddFirstname.text.toString()
            val WypAddLastname = WypAddLastname.text.toString()
            val conect =  WypAddFirstname + " " + WypAddLastname + " " +
                    intent.getCharSequenceExtra("wyp_us_email_add").toString()
            itemViewModel = ViewModelProvider
                    .AndroidViewModelFactory
                    .getInstance(application)
                    .create(ItemViewModel::class.java)

            itemViewModel.updateLendItem(conect, WypAddEditText)
            val intent: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent: Intent = Intent(applicationContext, WypPage::class.java)
        startActivity(intent)
    }
    fun checkPremission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), MY_CAMERA_PERMISSION_REQUEST)
        } else {
            codeScanner.startPreview()
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_CAMERA_PERMISSION_REQUEST && grantResults.isNotEmpty()
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            codeScanner.startPreview()
        } else {
            Toast.makeText(this, "Nie możesz skanować kodu QR bez uprawnień do aparatu!", Toast.LENGTH_SHORT).show()
        }
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
        WypAddFirstname.setText(intent.getCharSequenceExtra("wyp_us_Fname_add"))
        WypAddLastname.setText(intent.getCharSequenceExtra("wyp_us_Lname_add"))

    }
    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}

// Toast.makeText(this, "Scan Result: ${it.text}",Toast.LENGTH_LONG).show()

/*
    private fun initData(){
        var SpinnerUserAdapter = ArrayAdapter<Any>(this@WypAddPage, android.R.layout.simple_spinner_dropdown_item)
        userViewModel.getAllUser().observe(this, Observer {
            packageTypes ->

            packageTypes?.forEach {
                SpinnerUserAdapter.add(it.us_firstname + " " + it.us_lastname + " " +it.us_email)
            }
        })
        WypAddSpinner.adapter = SpinnerUserAdapter

    }
*/
    /*
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        result.text = WypAddSpinner.get(position).toString()
        // wynik = parent?.getItemAtPosition(position) as String
        //wynik.text = WypAddSpinner.get(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext,"Nie zaznaczono spinnera",Toast.LENGTH_SHORT).show()
    }
*/



