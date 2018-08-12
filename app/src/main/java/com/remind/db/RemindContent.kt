package com.remind.db

import test.com.maintest.RemindClassify

/**
 * 提醒类
 */
class RemindContent{
    var id: Int = 0
    var finishTime: Long = 0L
    var content: String
    var ring: String = ""
    var autoChange: Int = 1
    var notify: Int = 1

    var imagePath: String = ""
    var remindClassify: Int = RemindClassify.WALLPAPER_REMIND
    var isRemind: Boolean = false

    constructor(id: Int, finishTime: Long, content: String, ring: String, autoChange: Int, notify: Int, imagePath: String, remindClassify: Int) {
        this.id = id
        this.finishTime = finishTime
        this.content = content
        this.ring = ring
        this.autoChange = autoChange
        this.notify = notify
        this.imagePath = imagePath
        this.remindClassify = remindClassify
    }

    constructor(finishTime: Long, content: String, ring: String, autoChange: Int, notify: Int, imagePath: String, remindClassify: Int) {
        this.finishTime = finishTime
        this.content = content
        this.ring = ring
        this.autoChange = autoChange
        this.notify = notify
        this.imagePath = imagePath
        this.remindClassify = remindClassify
    }

    constructor(content: String) {
        this.content = content
    }
}