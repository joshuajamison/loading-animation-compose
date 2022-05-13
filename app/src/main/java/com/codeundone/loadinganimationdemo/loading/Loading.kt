package com.codeundone.loadinganimationdemo.loading

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codeundone.loadinganimationdemo.R
import kotlinx.coroutines.delay

/**
 * Experimental and maybe Deprecated unless future Compose updates make this better?
 * This code does not work well and is not currently in use. Animation looks bad.
 */
@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun Loading() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val image = AnimatedImageVector.animatedVectorResource(
            id = R.drawable.fusion_progress_indeterminate
        )
        val totalDuration = image.totalDuration.toLong()
        var atEnd by remember { mutableStateOf(false) }

        suspend fun runAnim() {
            while (true) {
                delay(totalDuration)
                atEnd = !atEnd
            }
        }

        LaunchedEffect(image) {
            runAnim()
        }

        Image(
            painter = rememberAnimatedVectorPainter(
                animatedImageVector = image,
                atEnd = atEnd
            ),
            modifier = Modifier.wrapContentSize(align = Alignment.Center),
            contentDescription = "Loading animation"
        )
    }
}

@Preview
@Composable
fun PreviewLoading() {
    Loading()
}
