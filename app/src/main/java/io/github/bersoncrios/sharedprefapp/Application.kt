package io.github.bersoncrios.sharedprefapp

import android.app.Application
import io.github.bersoncrios.sharedprefapp.Application.Companion

val prefs: Prefs by lazy {
    io.github.bersoncrios.sharedprefapp.Application.prefs!!
}

class Application: Application()
{
    companion object {
        var prefs: Prefs? = null
        lateinit var instance: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        prefs = Prefs(applicationContext)
    }
}