package com.abualgait.msayed.egdroidathomechallenge

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.util.Log
import android.view.View
import android.view.WindowManager
import java.text.SimpleDateFormat
import java.util.*

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}


inline val Context.screenWidth: Int
    get() = Point().also {
        (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getSize(
            it
        )
    }.x
inline val View.screenWidth: Int
    get() = context!!.screenWidth

fun getValueAnimator(
    forward: Boolean = true,
    duration: Long,
    delay: Long,
    interpolator: TimeInterpolator,
    updateListener: (progress: Float) -> Unit
): ValueAnimator {
    val a =
        if (forward) ValueAnimator.ofFloat(0f, 1f)
        else ValueAnimator.ofFloat(1f, 0f)
    a.addUpdateListener { updateListener(it.animatedValue as Float) }
    a.duration = duration
    a.startDelay = delay
    a.interpolator = interpolator
    a.repeatMode = ValueAnimator.REVERSE
    a.repeatCount = 0
    return a
}

val timeNow = SimpleDateFormat("hh:mm a", Locale.US).format(Date())
