package com.universe.totalplaytest.core.utils

import android.content.Context
import android.util.TypedValue

fun Int.dpToPx(context: Context): Int {
    val metrics = context.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), metrics).toInt()
}
fun String.isValidAccount():Boolean = this.length>4
fun String.isValidPassword():Boolean =this.length>7