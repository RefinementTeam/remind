package com.remind.clock

import android.os.Bundle
import com.remind.BaseActivity
import com.remind.R

/**
 * 闹钟界面
 */
class ClockActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
    }
}
