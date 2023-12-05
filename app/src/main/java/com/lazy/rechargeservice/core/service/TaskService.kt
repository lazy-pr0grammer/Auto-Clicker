package com.lazy.rechargeservice.core.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.accessibilityservice.GestureDescription.StrokeDescription
import android.annotation.SuppressLint
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent


/**
 * Created by Anindya Das on 12/5/23 12:24 PM
 **/
class TaskService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }

    override fun onInterrupt() {
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        autoClick(2000, 100, 950, 581)
    }

    @SuppressLint("NewApi")
    fun autoClick(startTimeMs: Int, durationMs: Int, x: Int, y: Int) {
        val isCalled =
            dispatchGesture(gestureDescription(startTimeMs, durationMs, x, y)!!, null, null)
        println(isCalled)
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
}