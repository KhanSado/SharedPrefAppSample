package io.github.bersoncrios.sharedprefapp

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class Prefs(context: Context) {

    private val EMAIL = "email"
    private val PASS = "pass"
    private val NAME = "name"
    private val TEMA = "tema"
    private val DEFAULT_USER = "default_user"

    private val APP_PREFS = "prefs"
    private val preferences: SharedPreferences = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE)

    private val mainKeyAlias by lazy {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        MasterKeys.getOrCreate(keyGenParameterSpec)
    }

    private val encryptedSharedPrefs by lazy {
        val sharedPrefsFile = "EncryptPref"

        EncryptedSharedPreferences.create(
            sharedPrefsFile,
            mainKeyAlias,
            context.applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    var email: String?
        get() = preferences.getString(EMAIL, "")
        set(value) = preferences.edit().putString(EMAIL, value).apply()

    var pass: Int
        get() = encryptedSharedPrefs.getInt(PASS, 0)
        set(value) = encryptedSharedPrefs.edit().putInt(PASS, value).apply()

    var name: String?
        get() = preferences.getString(NAME, "")
        set(value) = preferences.edit().putString(NAME, value).apply()

    var tema: String?
        get() = preferences.getString(TEMA, "")
        set(value) = preferences.edit().putString(TEMA, value).apply()

    var default_user: Boolean
        get() = preferences.getBoolean(DEFAULT_USER, false)
        set(value) = preferences.edit().putBoolean(DEFAULT_USER, value).apply()
}