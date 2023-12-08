package com.lazy.rechargeservice.core.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.accessibilityservice.GestureDescription.StrokeDescription
import android.annotation.SuppressLint
import android.graphics.Path
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.accessibility.AccessibilityEvent


/**
 * Created by Anindya Das on 12/5/23 12:24 PM
 **/
class TaskService : AccessibilityService() {
    private var index = 0
    private var taps = mutableListOf(Tap(661, 1321, 1000, 100), Tap(563, 1798, 3000, 100))

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
    }

    override fun onInterrupt() {
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Handler(Looper.getMainLooper()).postDelayed({
            firstTap()
        }, 2000)
    }

    @SuppressLint("NewApi")
    fun autoClick(startTimeMs: Int, durationMs: Int, x: Int, y: Int): Boolean {
        return dispatchGesture(gestureDescription(startTimeMs, durationMs, x, y)!!, null, null)
    }

    @SuppressLint("NewApi")
    fun gestureDescription(startTimeMs: Int, durationMs: Int, x: Int, y: Int): GestureDescription? {
        val path = Path()
        path.moveTo(x.toFloat(), y.toFloat())
        return createGestureDescription(
            StrokeDescription(
                path,
                startTimeMs.toLong(),
                durationMs.toLong()
            )
        )
    }

    @SuppressLint("NewApi")
    fun createGestureDescription(vararg strokes: StrokeDescription?): GestureDescription? {
        val builder = GestureDescription.Builder()
        for (stroke in strokes) {
            builder.addStroke(stroke!!)
        }
        return builder.build()
    }

    private fun firstTap() {
        autoClick(1000, 100, 661, 1321)
        Handler(Looper.getMainLooper()).postDelayed({
            secondStep()
        }, 2000)
    }

    private fun secondStep() {
        autoClick(2000, 100, 563, 1798)
        Handler(Looper.getMainLooper()).postDelayed({
            thirdStep()
        }, 2100)
    }

    private fun thirdStep() {
        autoClick(2000, 100, 535, 2262)
        Handler(Looper.getMainLooper()).postDelayed({
            fourthStep()
        }, 2150)
    }

    private fun fourthStep() {
        autoClick(2000, 100, 535, 2262)
        Handler(Looper.getMainLooper()).postDelayed({
            fifthStep()
        }, 2200)
    }

    private fun fifthStep() {
        autoClick(2000, 100, 555, 1950)
        Handler(Looper.getMainLooper()).postDelayed({
            sixthStep()
        }, 2250)
    }

    private fun sixthStep() {
        autoClick(2000, 100, 221, 1800)
        Handler(Looper.getMainLooper()).postDelayed({
            autoClick(2000, 100, 591, 1657)
        }, 2300)
    }

    data class Tap(
        val x: Int,
        val y: Int,
        val startTimeMs: Int,
        val durationMs: Int
    )
}