package com.codeundone.loadinganimationdemo.loading

import android.content.Context
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.core.widget.ContentLoadingProgressBar
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.codeundone.loadinganimationdemo.R

open class FusionProgress @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ContentLoadingProgressBar(context, attrs) {

    private val drawable =
        AnimatedVectorDrawableCompat.create(context, R.drawable.fusion_progress_indeterminate)

    protected open var looper = object : Animatable2Compat.AnimationCallback() {
        override fun onAnimationEnd(drawable: Drawable?) {
            postOnAnimation {
                (drawable as Animatable).start()
            }
        }
    }

    init {
        isIndeterminate = true
        indeterminateDrawable = drawable
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        drawable?.registerAnimationCallback(looper)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        drawable?.unregisterAnimationCallback(looper)
    }
}
