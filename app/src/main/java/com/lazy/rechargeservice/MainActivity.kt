package com.lazy.rechargeservice

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var access = 0
            try {
                access = Settings.Secure.getInt(
                    this.contentResolver,
                    Settings.Secure.ACCESSIBILITY_ENABLED
                )
            } catch (e: Settings.SettingNotFoundException) {
                e.printStackTrace()
                //put a Toast
            }
            if (access == 0) {
                val myIntent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(myIntent)
            }
        }
    }
}