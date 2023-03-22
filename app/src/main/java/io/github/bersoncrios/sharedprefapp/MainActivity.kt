package io.github.bersoncrios.sharedprefapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    private val TAG = "MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs.email = "bersondev@gmail.com"
        prefs.pass = 123456
        prefs.name = "Guilherme"
        prefs.tema = TEMA.CLARO.name
        prefs.default_user = true

        Log.d(TAG, "onCreate: ${prefs.email}")
        Log.d(TAG, "onCreate: ${prefs.pass}")
        Log.d(TAG, "onCreate: ${prefs.name}")
        Log.d(TAG, "onCreate: ${prefs.tema}")
        Log.d(TAG, "onCreate: ${prefs.default_user}")


        if (prefs.tema!! == TEMA.ESCURO.name){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            delegate.applyDayNight()
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            delegate.applyDayNight()
        }


    }
}