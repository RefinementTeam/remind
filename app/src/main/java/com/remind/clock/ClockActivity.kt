package com.remind.clock

import android.os.Bundle
import android.support.v7.widget.AppCompatEditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.remind.BaseActivity
import com.remind.R
import com.remind.view.WheelView

/**
 * 闹钟界面
 */
class ClockActivity : BaseActivity() {

    private lateinit var clock_back: ImageView
    private lateinit var clock_save: TextView
    private lateinit var click_content_edit: AppCompatEditText
    private lateinit var clock_time_hour: WheelView
    private lateinit var clock_time_min: WheelView
    private lateinit var clock_weekday: TextView
    private lateinit var clock_weekend: TextView
    private lateinit var clock_clock_audio: ImageView
    private lateinit var clock_clock_shake: ImageView
    private lateinit var clock_audio_select_ll: LinearLayout
    private lateinit var clock_audio_name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
        init()
    }

    private fun init() {
        clock_back = findViewById(R.id.clock_back)
        clock_save = findViewById(R.id.clock_save)
        click_content_edit = findViewById(R.id.click_content_edit)
        clock_time_hour = findViewById(R.id.clock_time_hour)
        clock_time_min = findViewById(R.id.clock_time_min)
        clock_weekday = findViewById(R.id.clock_weekday)
        clock_weekend = findViewById(R.id.clock_weekend)
        clock_clock_audio = findViewById(R.id.clock_clock_audio)
        clock_clock_shake = findViewById(R.id.clock_clock_shake)
        clock_audio_select_ll = findViewById(R.id.clock_audio_select_ll)
        clock_audio_name = findViewById(R.id.clock_audio_name)
    }
}
