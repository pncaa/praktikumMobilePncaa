package com.unsoed.informatikamobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.informatikamobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()
    }

    private fun initNavigation() {
        // Tombol lama
        binding.buttonPage.setOnClickListener {
            startActivity(Intent(this, Halaman2Activity::class.java))
        }

        // ✅ Tombol baru menuju DaftarBukuActivity
        binding.buttonDaftarBuku.setOnClickListener {
            startActivity(Intent(this, DaftarBukuActivity::class.java))
        }
    }
}
