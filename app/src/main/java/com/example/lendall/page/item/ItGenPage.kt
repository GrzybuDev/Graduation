package com.example.lendall.page.item
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.lendall.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.io.File
import java.io.FileOutputStream
class ItGenPage : AppCompatActivity() {
    val EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 2222
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_it_gen_page)
        val content = intent.getCharSequenceExtra("it_name_gen").toString()
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 512, 512)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
            }
        }
        checkPremission()
        saveImage(bitmap)
        val intent: Intent = Intent(applicationContext,ItPage::class.java)
        startActivity(intent)

    }
    fun checkPremission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    , EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE)
        } else {
            ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    , EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE)
        }

    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE && grantResults.isNotEmpty()
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    , EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE)
        } else {
            Toast.makeText(this, "Nie możesz skanować kodu QR bez uprawnień do aparatu. " +
                    "Proszę zmienić uprawnienia dla aplikacji w ustawieniach.", Toast.LENGTH_SHORT).show()
        }
    }
    
    fun saveImage(image: Bitmap): String {
        var savedImagePath: String? = null
        var imageFileName = intent.getCharSequenceExtra("it_name_gen").toString() + "_" +getTimeStamp() + ".jpg"
        var storageDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "/LendAllQR")
        var success = true
        if (!storageDir.exists()) {
            success = storageDir.mkdirs()
        }
        if (success) {
            var imageFile = File(storageDir, imageFileName)
            savedImagePath = imageFile.getAbsolutePath()
            try {
                var fOut = FileOutputStream(imageFile)
                image.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
                fOut.close()
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
            var mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            var f = File(savedImagePath)
            var contentUri = Uri.fromFile(f)
            mediaScanIntent.setData(contentUri)
            sendBroadcast(mediaScanIntent)
            Toast.makeText(this,"Kod QR zapisano w galerii zdjęć w folderze LendAllQR !",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"ERROR SAVING IMAGE",Toast.LENGTH_SHORT).show()
        }
        return savedImagePath!!
    }
    fun getTimeStamp(): String? {
        val tsLong = System.currentTimeMillis() / 1000
        val ts = tsLong.toString()
        return ts
    }
}