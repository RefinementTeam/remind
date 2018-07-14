package com.remind

import android.graphics.Point


//获取屏幕高宽
fun getScreen(): Point {
    val resources = RemindApplication.getContext().getResources()
    val dm = resources.getDisplayMetrics()
    val point = Point(dm.widthPixels, dm.heightPixels)
    return point
}

