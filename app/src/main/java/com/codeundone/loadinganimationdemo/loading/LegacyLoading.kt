package com.codeundone.loadinganimationdemo.loading

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.codeundone.loadinganimationdemo.R

@Composable
fun LegacyLoading() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
    ) {
        AndroidView(
            factory = { FusionProgress(it) },
            modifier = Modifier
                .size(
                    dimensionResource(R.dimen.progress_width),
                    dimensionResource(R.dimen.progress_height)
                )
        )
    }
}

@Preview
@Composable
fun PreviewLegacyLoading() {
    LegacyLoading()
}
