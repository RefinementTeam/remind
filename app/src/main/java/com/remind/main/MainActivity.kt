package com.remind.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.remind.R
import com.remind.view.floatbutton.FloatingActionButton
import com.remind.view.floatbutton.FloatingActionMenu
import test.com.sqlitedemo.work.WorkTool

/**
 * 主界面
 */
class MainActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var fab1: FloatingActionButton
    lateinit var fab2: FloatingActionButton
    lateinit var menu_red: FloatingActionMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        menu_red = findViewById(R.id.menu_red)

        fab1.setOnClickListener(this)
        fab2.setOnClickListener(this)

        val bt: Button = findViewById(R.id.bt)

        bt.setOnClickListener {
            WorkTool.getInstence().executeWork()
        }

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.fab1 -> {
                menu_red.close(true)
                Toast.makeText(this, "fab1", Toast.LENGTH_SHORT).show()
            }
            R.id.fab2 -> Toast.makeText(this, "fab2", Toast.LENGTH_SHORT).show()
        }
    }
}
