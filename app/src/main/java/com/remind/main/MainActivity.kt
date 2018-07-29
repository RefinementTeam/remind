package com.remind.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.remind.R
import test.com.sqlitedemo.work.WorkTool

/**
 * 主界面
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt: Button = findViewById(R.id.bt)

        bt.setOnClickListener {
            WorkTool.getInstence().executeWork()
        }

    }
}
