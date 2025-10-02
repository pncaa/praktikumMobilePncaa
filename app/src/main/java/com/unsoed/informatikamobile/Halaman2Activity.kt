package com.unsoed.informatikamobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.informatikamobile.databinding.ActivityHalaman2Binding



class Halaman2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHalaman2Binding
    private val latitude = -7.429427
    private val longitude = 109.338082
    private val gMapsUrl = "http://maps.google.com/maps?q=loc:"
    private val packageMaps = "com.google.android.apps.maps"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        // Pastikan ID di XML sesuai dengan yang diakses di sini
        binding.layoutLocation.let {
            it.imgIcon.setImageResource(R.drawable.ic_location)
            it.tvLayout.setText(R.string.alamat)
        }
        binding.layoutPhone.let {
            it.imgIcon.setImageResource(R.drawable.ic_phone)
            it.tvLayout.setText(R.string.telepon)
        }
        binding.layoutEmail.let {
            it.imgIcon.setImageResource(R.drawable.ic_email)
            it.tvLayout.setText(R.string.email)
        }
        binding.layoutIg.let {
            it.imgIcon.setImageResource(R.drawable.ic_himpunan)
            it.tvLayout.setText(R.string.ig_himpunan)
        }
        binding.layoutHimpunan.let {
            it.imgIcon.setImageResource(R.drawable.ic_instagram)
            it.tvLayout.setText(R.string.instagram)
        }
        binding.layoutBuku.let {
            it.imgIcon.setImageResource(R.drawable.ic_book)
            it.tvLayout.setText(R.string.book)
        }

    }

    private fun initListener() {
        binding.layoutLocation.root.setOnClickListener {
            val gMapsIntentUri = Uri.parse("${gMapsUrl}$latitude,$longitude")
            val mapIntent = Intent(Intent.ACTION_VIEW, gMapsIntentUri)
            mapIntent.setPackage(packageMaps)

            // Cek apakah aplikasi Google Maps tersedia
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                // Fallback ke browser jika Google Maps tidak terinstall
                val webIntent = Intent(Intent.ACTION_VIEW, gMapsIntentUri)
                startActivity(webIntent)
            }
        }

        binding.layoutIg.root.setOnClickListener {
            val igUri = Uri.parse(getString(R.string.ig_himpunan))
            val intent = Intent(Intent.ACTION_VIEW, igUri)

            // Cek apakah Instagram terinstall
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Fallback ke browser
                val webIntent = Intent(Intent.ACTION_VIEW, igUri)
                startActivity(webIntent)
            }
        }

        binding.layoutEmail.root.setOnClickListener {
            val email = getString(R.string.email)
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        binding.layoutPhone.root.setOnClickListener {
            val phoneNumber = getString(R.string.telepon)
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        binding.layoutBuku.root.setOnClickListener {
            startActivity(Intent(this, DaftarBukuActivity::class.java))
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}