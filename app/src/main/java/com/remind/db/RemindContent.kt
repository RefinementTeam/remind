package com.remind.db

/**
 * 提醒类
 */
class RemindContent{
    var id: Int = 0
    var finishTime: Long = 0L
    var content: String
    var ring: String
    var autoChange: Int = 1
    var notify: Int = 1

    constructor(id: Int, finishTime: Long, content: String, ring: String, autoChange: Int, notify: Int) {
        this.id = id
        this.finishTime = finishTime
        this.content = content
        this.ring = ring
        this.autoChange = autoChange
        this.notify = notify
    }

    constructor(finishTime: Long, content: String, ring: String, autoChange: Int, notify: Int) {
        this.finishTime = finishTime
        this.content = content
        this.ring = ring
        this.autoChange = autoChange
        this.notify = notify
    }
}