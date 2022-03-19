package com.example.sewallpaper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import com.example.sewallpaper.HexToJetpackColor.getColor
import com.example.sewallpaper.ui.theme.SEWallpaperTheme
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.insets.systemBarsPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {

        }
    }
}

@OptIn(ExperimentalGraphicsApi::class)
@Composable
fun BarStack() {
    var steps = 0.0
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        getColor("1a0047"),
                        getColor("300604")
                    )
                )
            )
    ) {
        for (i in 1..9) {
            steps += 0.1
            if(i <= 5) {

                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight((1.1 - steps).toFloat()).zIndex((5 - i).toFloat())
                ) {
                    Bar(shape = RectangleShape)
                }
            }
            else{
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight((0.1 + steps).toFloat()).zIndex((i).toFloat())
                ) {
                    Bar(shape = RectangleShape)
                }
            }
        }
    }
}

@Composable
fun Bar(shape: Shape) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .shadow(elevation = 64.dp)
            .clip(shape)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        getColor("005a3ec3"),
                        getColor("5a3ec3"),
                        getColor("eba5c5"),
                        getColor("e1d4b7"),
                        getColor("e9b74c"),
                        getColor("cf1403"),
                        getColor("00cf1403")

                    )
                )
            )
    )
}

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SEWallpaperTheme {
        BarStack()
    }
}