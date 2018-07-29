package com.remind.work

import android.content.Intent
import android.widget.Toast
import androidx.work.Worker
import com.remind.RemindApplication
import com.remind.service.TestService
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemindWork : Worker() {

    override fun doWork(): Result {

        RemindApplication.getContext().startService(Intent(RemindApplication.getContext(),TestService::class.java))

        Observable.create(ObservableOnSubscribe<String> {
            while (true) {
                Thread.sleep(5000)
                it.onNext("1")
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            Toast.makeText(RemindApplication.getContext(), "Work is live !!!", Toast.LENGTH_SHORT).show()
        }

        return Result.SUCCESS
    }

}