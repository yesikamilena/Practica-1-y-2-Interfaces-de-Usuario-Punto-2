package com.yesikamilenacarvajal.misseriesapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yesikamilenacarvajal.misseriesapp.R
import com.yesikamilenacarvajal.misseriesapp.databinding.ActivitySplashBinding
import com.yesikamilenacarvajal.misseriesapp.ui.signup.SignUpActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        val timer= Timer()
        timer.schedule(timerTask {
            val intent = Intent(this@SplashActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        },2000
        )

        /*
        splashBinding.imageView.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }*/
        Log.d("onCreate","Ok")
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","Ok")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume","Ok")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","Ok")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","Ok")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","Ok")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","Ok")
    }

}