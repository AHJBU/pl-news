package com.plnews

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.plnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNewsDesign.setOnClickListener {
            startActivity(Intent(this, NewsDesignActivity::class.java))
        }

        binding.btnCustomize.setOnClickListener {
            startActivity(Intent(this, CustomizeTemplateActivity::class.java))
        }

        // إعداد روابط التواصل الاجتماعي
        binding.iconFacebook.setOnClickListener {
            openLink(getString(R.string.facebook_url))
        }

        binding.iconTwitter.setOnClickListener {
            openLink(getString(R.string.twitter_url))
        }

        binding.iconInstagram.setOnClickListener {
            openLink(getString(R.string.instagram_url))
        }

        binding.iconTelegram.setOnClickListener {
            openLink(getString(R.string.telegram_url))
        }

        binding.iconWhatsApp.setOnClickListener {
            openLink(getString(R.string.whatsapp_url))
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
