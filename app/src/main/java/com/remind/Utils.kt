package com.remind

import android.graphics.Point

object Utils{
    //获取屏幕高宽
    fun getScreen(): Point {
        val resources = RemindApplication.getContext().getResources()
        val dm = resources.getDisplayMetrics()
        val point = Point(dm.widthPixels, dm.heightPixels)
        return point
    }

    //dp to px
    fun dp2px(dpValue: Float): Int {
        val scale = RemindApplication.getContext().getResources().getDisplayMetrics().density
        return (dpValue * scale + 0.5f).toInt()
    }
}



