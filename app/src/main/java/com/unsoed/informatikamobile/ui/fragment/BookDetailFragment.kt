package com.unsoed.informatikamobile.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.bumptech.glide.Glide
import com.unsoed.informatikamobile.R
import com.unsoed.informatikamobile.databinding.FragmentBookDetailBinding

class BookDetailFragment(
    private val title: String,
    private val author: String,
    private val year: String,
    private val coverId: Int
) : BottomSheetDialogFragment() {

    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.CustomBottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData() // ✅ panggil fungsi untuk menampilkan data
    }

    // ✅ Fungsi untuk mengisi data ke tampilan fragment
    private fun loadData() {
        binding.textViewTitle.text = title
        binding.textViewAuthor.text = author
        binding.textViewYear.text = year

        // Jika coverId valid, tampilkan gambar dari API
        if (coverId != 0) {
            Glide.with(this)
                .load("https://covers.openlibrary.org/b/id/${coverId}-L.jpg")
                .into(binding.imageViewCover)
        } else {
            // Jika tidak ada gambar, tampilkan pesan atau placeholder
            Toast.makeText(requireContext(), "Cover tidak tersedia", Toast.LENGTH_SHORT).show()
            binding.imageViewCover.setImageResource(R.drawable.book_not_found)
        }
    }


    // ✅ Hapus binding agar tidak terjadi memory leak
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
