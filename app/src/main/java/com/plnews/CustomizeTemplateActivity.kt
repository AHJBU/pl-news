package com.plnews

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.plnews.databinding.ActivityCustomizeTemplateBinding
import java.io.InputStream

class CustomizeTemplateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomizeTemplateBinding
    private var selectedImageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomizeTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelectImage.setOnClickListener {
            selectImage()
        }

        binding.btnGenerate.setOnClickListener {
            val text = binding.etNewsText.text.toString()
            selectedImageBitmap?.let {
                val result = ImageEditor.addTextToImage(it, text)
                binding.ivResult.setImageBitmap(result)
            }
        }
    }

    private fun selectImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            val uri: Uri? = data?.data
            uri?.let {
                val inputStream: InputStream? = contentResolver.openInputStream(it)
                selectedImageBitmap = BitmapFactory.decodeStream(inputStream)
                binding.ivResult.setImageBitmap(selectedImageBitmap)
            }
        }
    }
}
