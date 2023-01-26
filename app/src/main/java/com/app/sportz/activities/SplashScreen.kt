package com.app.sportz.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.app.sportz.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleScreen()

    }


    private fun handleScreen() {
        val handler = Handler()
        handler.postDelayed({
            val i = Intent(applicationContext, MainActivity::class.java)
            finish()
            startActivity(i)
        }, 2000)
    }
}