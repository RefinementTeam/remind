package test.com.sqlitedemo.work

import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.remind.work.RemindWork

class WorkTool private constructor() {

    companion object {
        fun getInstence() = Holder.instance

    }

    private object Holder {
        val instance = WorkTool()
    }

    fun executeWork() {
        val workRequest = OneTimeWorkRequest.Builder(RemindWork::class.java).build()
        WorkManager.getInstance().enqueue(workRequest)
    }
}