package com.plnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.plnews.databinding.ActivityNewsDesignBinding

class NewsDesignActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerate.setOnClickListener {
            val text = binding.etNewsText.text.toString()
            val type = when {
                binding.rbBreaking.isChecked -> TemplateType.BREAKING
                binding.rbNormal.isChecked -> TemplateType.NORMAL
                binding.rbUpdate.isChecked -> TemplateType.UPDATE
                else -> TemplateType.NORMAL
            }

            val bitmap = TemplateGenerator.generateImage(this, text, type)
            binding.ivResult.setImageBitmap(bitmap)
        }
    }
}
