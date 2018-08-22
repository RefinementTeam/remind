package com.remind.clock

import android.os.Bundle
import android.support.v7.widget.AppCompatEditText
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bruce.pickerview.LoopScrollListener
import com.bruce.pickerview.LoopView
import com.remind.BaseActivity
import com.remind.R

/**
 * 闹钟界面
 */
class ClockActivity : BaseActivity(), View.OnClickListener {

    private lateinit var clock_back: ImageView
    private lateinit var clock_save: TextView
    private lateinit var click_content_edit: AppCompatEditText
    private lateinit var clock_time_hour: LoopView
    private lateinit var clock_time_min: LoopView
    private lateinit var clock_weekday: TextView
    private lateinit var clock_weekend: TextView
    private lateinit var clock_clock_audio: ImageView
    private lateinit var clock_clock_shake: ImageView
    private lateinit var clock_audio_select_ll: LinearLayout
    private lateinit var clock_audio_name: TextView
    private lateinit var clock_week_day1: ImageView
    private lateinit var clock_week_day2: ImageView
    private lateinit var clock_week_day3: ImageView
    private lateinit var clock_week_day4: ImageView
    private lateinit var clock_week_day5: ImageView
    private lateinit var clock_week_day6: ImageView
    private lateinit var clock_week_day7: ImageView

    private var mon_select = false
    private var tue_select = false
    private var wed_select = false
    private var thu_select = false
    private var fri_select = false
    private var sat_select = false
    private var sun_select = false

    private var selectAudio = false
    private var selectShake = false

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
        clock_week_day1 = findViewById(R.id.clock_week_day1)
        clock_week_day2 = findViewById(R.id.clock_week_day2)
        clock_week_day3 = findViewById(R.id.clock_week_day3)
        clock_week_day4 = findViewById(R.id.clock_week_day4)
        clock_week_day5 = findViewById(R.id.clock_week_day5)
        clock_week_day6 = findViewById(R.id.clock_week_day6)
        clock_week_day7 = findViewById(R.id.clock_week_day7)

        clock_clock_audio.setOnClickListener(this)
        clock_clock_shake.setOnClickListener(this)

        clock_week_day1.setOnClickListener(this)
        clock_week_day2.setOnClickListener(this)
        clock_week_day3.setOnClickListener(this)
        clock_week_day4.setOnClickListener(this)
        clock_week_day5.setOnClickListener(this)
        clock_week_day6.setOnClickListener(this)
        clock_week_day7.setOnClickListener(this)

        val hourList = mutableListOf<String>()
        for (i in 1..24) {
            hourList.add("$i")
        }
        val minList = mutableListOf<String>()
        for (i in 1..60) {
            minList.add("$i")
        }
        clock_time_hour.setDataList(hourList)
        clock_time_min.setDataList(minList)
        clockTimeListener()
    }

    fun clockTimeListener() {
        clock_time_hour.setLoopListener(LoopScrollListener {

        })
        clock_time_min.setLoopListener(LoopScrollListener {

        })
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.clock_clock_audio -> {
                if (selectAudio) {
                    selectAudio = false
                    clock_clock_audio.setImageResource(R.mipmap.clock_aduio_unselect)
                } else {
                    selectAudio = true
                    clock_clock_audio.setImageResource(R.mipmap.clock_audio_select)
                }
            }
            R.id.clock_clock_shake -> {
                if (selectShake) {
                    selectShake = false
                    clock_clock_shake.setImageResource(R.mipmap.clock_shake_unselect)
                } else {
                    selectShake = true
                    clock_clock_shake.setImageResource(R.mipmap.clock_shake_select)
                }
            }
            R.id.clock_week_day1 -> {
                if (mon_select) {
                    mon_select = false
                    clock_week_day1.setImageResource(R.mipmap.mon_unselect)
                } else {
                    mon_select = true
                    clock_week_day1.setImageResource(R.mipmap.mon_select)
                }
            }
            R.id.clock_week_day2 -> {
                if (tue_select) {
                    tue_select = false
                    clock_week_day2.setImageResource(R.mipmap.tue_unselect)
                } else {
                    tue_select = true
                    clock_week_day2.setImageResource(R.mipmap.tue_select)
                }
            }
            R.id.clock_week_day3 -> {
                if (wed_select) {
                    wed_select = false
                    clock_week_day3.setImageResource(R.mipmap.wed_unselect)
                } else {
                    wed_select = true
                    clock_week_day3.setImageResource(R.mipmap.wed_select)
                }
            }
            R.id.clock_week_day4 -> {
                if (thu_select) {
                    thu_select = false
                    clock_week_day4.setImageResource(R.mipmap.thr_unselect)
                } else {
                    thu_select = true
                    clock_week_day4.setImageResource(R.mipmap.thr_select)
                }
            }
            R.id.clock_week_day5 -> {
                if (fri_select) {
                    fri_select = false
                    clock_week_day5.setImageResource(R.mipmap.fri_unselect)
                } else {
                    fri_select = true
                    clock_week_day5.setImageResource(R.mipmap.fri_select)
                }
            }
            R.id.clock_week_day6 -> {
                if (sat_select) {
                    sat_select = false
                    clock_week_day6.setImageResource(R.mipmap.sat_unselect)
                } else {
                    sat_select = true
                    clock_week_day6.setImageResource(R.mipmap.sat_select)
                }
            }
            R.id.clock_week_day7 -> {
                if (sun_select) {
                    sun_select = false
                    clock_week_day7.setImageResource(R.mipmap.sun_unselect)
                } else {
                    sun_select = true
                    clock_week_day7.setImageResource(R.mipmap.sun_select)
                }
            }
        }

    }
}
