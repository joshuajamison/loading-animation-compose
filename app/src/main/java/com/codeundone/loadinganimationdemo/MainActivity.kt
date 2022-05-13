package com.codeundone.loadinganimationdemo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codeundone.loadinganimationdemo.loading.LegacyLoading
import com.codeundone.loadinganimationdemo.loading.Loading

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var showLegacy by remember { mutableStateOf(false) }

            Surface {
                Column {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        onClick = {
                            showLegacy = !showLegacy
                        }
                    ) {
                        Text(text = "Toggle")
                    }

                    Text(
                        if (showLegacy) {
                            "Legacy ContentLoadingProgressBar"
                        } else {
                            "Compose AnimatedImageVector"
                        }
                    )

                    if (showLegacy) {
                        LegacyLoading()
                    } else {
                        Loading()
                    }
                }
            }
        }
    }
}

