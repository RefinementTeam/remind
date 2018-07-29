package com.remind.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.remind.R

/**
 * 启动界面
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startActivity(Intent(this,MainActivity::class.java))
    }
}
