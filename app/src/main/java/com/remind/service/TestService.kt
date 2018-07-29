package com.remind.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.remind.RemindApplication
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TestService : Service() {

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("LJW", "启动服务")
        Observable.create(ObservableOnSubscribe<String> {
            while (true) {
                Thread.sleep(5000)
                it.onNext("1")
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            Toast.makeText(RemindApplication.getContext(), "Service is live !!!", Toast.LENGTH_SHORT).show()
        }
    }


}