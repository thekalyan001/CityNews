package com.androiddevs.mvvmnewsapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.androiddevs.mvvmnewsapp.ui.NewsActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {
    var appname: TextView? = null
    var splashimg: ImageView? = null
    var lottieAnimationView: LottieAnimationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //hide the action bar for this activity
        supportActionBar?.hide()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        img.animate().translationY((-2500).toFloat()).setDuration(1000).startDelay = 5000
        app_name.animate().translationY(2000F).setDuration(1000).startDelay = 5000
        lottie.animate().translationY(1500f).setDuration(1000).startDelay = 5000
        Handler().postDelayed(Runnable {
            startActivity(Intent(this@SplashScreen, NewsActivity::class.java))
            finish()
        }, 6000)
    }
}