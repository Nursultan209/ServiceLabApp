package com.example.servicelabapp

import android.app.Service
import android.content.Intent
import android.os.IBinder

class RandomCharacterService : Service() {

    private var isRunning = false
    private val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isRunning = true
        Thread {
            while (isRunning) {
                Thread.sleep(1000)
                val randomChar = alphabet.random()
                val broadcast = Intent("my.custom.action.tag.lab6")
                broadcast.putExtra("randomCharacter", randomChar)
                sendBroadcast(broadcast)
            }
        }.start()
        return START_STICKY
    }

    override fun onDestroy() {
        isRunning = false
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
