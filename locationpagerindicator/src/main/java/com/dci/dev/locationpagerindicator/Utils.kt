package com.dci.dev.locationpagerindicator

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat

internal fun Drawable.tint(@ColorInt color: Int): Drawable {
    val wrapped = DrawableCompat.wrap(this)
    DrawableCompat.setTint(wrapped, color)
    return wrapped
}
