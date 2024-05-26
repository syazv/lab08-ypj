package com.syazv.lab08

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syazv.lab08.databinding.ActivityThanksBinding

class ThanksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThanksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThanksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.myFullName.text = intent.getStringExtra("name")
        binding.myPhoneNumber.text = intent.getStringExtra("phone")
        binding.sizeVerifyTextView.text = intent.getStringExtra("size")
        binding.pickupDateVerifTextView.text = intent.getStringExtra("date")
        binding.pickupTimeVerifTextView.text = intent.getStringExtra("time")

        binding.sendBtn.setOnClickListener {
            binding.ratingTextView.text = binding.ratingBarSelected.rating.toString()
        }
    }
}