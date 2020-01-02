package com.example.loftly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.foundation.DrawImage
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PostItem()
            }
        }
    }
}

@Composable
fun PostItem() {
    Card() {
        Padding(padding = 8.dp) {
           var image = +imageResource(R.drawable.house1)
            DrawImage(image)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        PostItem()
    }
}
