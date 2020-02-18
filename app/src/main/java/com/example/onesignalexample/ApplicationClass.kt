package com.example.onesignalexample

import android.app.Application

import com.onesignal.OneSignal

class ApplicationClass : Application() {
    init {
        mInstance = this
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this

        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()
    }

    companion object {
        private lateinit var mInstance: ApplicationClass
    }

    val instance: ApplicationClass
        @Synchronized get() = mInstance


}

