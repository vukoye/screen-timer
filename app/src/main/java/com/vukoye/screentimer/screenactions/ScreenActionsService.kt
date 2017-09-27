package com.vukoye.screentimer.screenactions

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder


class ScreenActionsService : Service(){
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        val receiver = ScreenReceiver()
        registerReceiver(receiver, filter)
        return super.onStartCommand(intent, flags, startId)
    }
}
