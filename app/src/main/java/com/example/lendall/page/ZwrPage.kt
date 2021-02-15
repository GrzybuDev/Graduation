package com.example.lendall.page
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.budiyev.android.codescanner.*
import com.example.lendall.R
import com.example.lendall.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_zwr_page.*
class ZwrPage : AppCompatActivity() {
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var codeScanner: CodeScanner
    val MY_CAMERA_PERMISSION_REQUEST = 1111
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zwr_page)
        codeScanner = CodeScanner(this, scanner_view)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                ZwrItName.setText(it.text)
            }
        }
        codeScanner.errorCallback = ErrorCallback {
            runOnUiThread {
                Toast.makeText(this, "Błąd aparatu ${it.message}", Toast.LENGTH_LONG).show()
            }
        }
        checkPremission()
        itemViewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(ItemViewModel::class.java)
        ZwrAcceptButton.setOnClickListener {
            val ZwrItName = ZwrItName.text.toString()
            itemViewModel.updateLendItem("Dostępne",ZwrItName)
            val intent: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
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
        if (requestCode == MY_CAMERA_PERMISSION_REQUEST && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            codeScanner.startPreview()
        } else {
            Toast.makeText(this, "Nie możesz skanować kodu QR bez uprawnień do aparatu!", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }
    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        var intent: Intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}