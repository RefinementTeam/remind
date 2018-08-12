package com.remind.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.remind.BaseActivity
import com.remind.R
import com.remind.clock.ClockActivity
import com.remind.db.RemindContent
import com.remind.main.adapter.MainAdapter
import com.remind.view.NewGridManager
import com.remind.view.floatbutton.FloatingActionButton
import com.remind.view.floatbutton.FloatingActionMenu
import com.remind.wallpager.ui.WallPagerEditActivity

/**
 * 主界面
 */
class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var fab1: FloatingActionButton
    private lateinit var fab2: FloatingActionButton
    private lateinit var menu_red: FloatingActionMenu
    private lateinit var main_recyclerview: RecyclerView
    private lateinit var adapter: MainAdapter
    private val showList: MutableList<RemindContent> by lazy {
        mutableListOf<RemindContent>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        menu_red = findViewById(R.id.menu_red)
        main_recyclerview = findViewById(R.id.main_recyclerview)
        main_recyclerview.layoutManager = NewGridManager(this, 2)

        fab1.setOnClickListener(this)
        fab2.setOnClickListener(this)

        for (i in 1..10) {
            val content = RemindContent("this is a $i")
            showList.add(content)
        }

        adapter = MainAdapter(this, showList)
        main_recyclerview.adapter = adapter
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.fab1 -> {
                menu_red.close(true)
                startActivity(Intent(this, ClockActivity::class.java))
            }
            R.id.fab2 -> {
                menu_red.close(true)
                startActivity(Intent(this, WallPagerEditActivity::class.java))
            }
        }
    }
}
