package com.example.loftly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import java.time.format.TextStyle
import androidx.ui.core.Text as Text1

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
fun listingsView(children: @Composable() () -> Unit) {
    children()
}

@Composable
fun PostItem() {
    Card(elevation = 2.dp) {
        Padding(padding = 8.dp) {
           Column {
              listingImage();
               listingInfo()
           }
        }
    }
}

@Composable
fun listingImage() {
    Container(expanded = true, height = 180.dp) {
        var image = +imageResource(R.drawable.house2)
        DrawImage(image)
    }
}

@Composable
fun listingInfo() {
    HeightSpacer(height = 16.dp)
    Address()
    HeightSpacer(height = 16.dp)
    FlowRow(
        mainAxisSize = LayoutSize.Expand,
        mainAxisAlignment = MainAxisAlignment.SpaceBetween,
        crossAxisAlignment = FlowCrossAxisAlignment.Center
    )  {
        AuthorInfo()
    }
}

@Composable
fun Address() {
    Text(
        "555 Terrace Point",
        style = androidx.ui.text.TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
    )
}

@Composable
fun AuthorInfo() {
    Row {
        Container(width = 40.dp, height = 40.dp) {
            Clip(shape = CircleShape) {
                DrawImage(image = +imageResource(R.drawable.profile2))
            }
        }
        Column(modifier = Spacing(left = 8.dp)) {
            Text(
                "Papa John",
                style = androidx.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600
                )
            )
            HeightSpacer(height = 2.dp)
            Text(
                "Property Owner",
                style = androidx.ui.text.TextStyle(
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )
            )
        }
    }
    Column() {
        Text(
            text = "Oct 24, 2019",
            style = androidx.ui.text.TextStyle(fontSize = 14.sp, color = Color.DarkGray)
        )
        Text(
            text = "200 Applicants",
            style = androidx.ui.text.TextStyle(fontSize = 14.sp, color = Color.DarkGray))

    }
}

@Preview
@Composable
fun DefaultPreview() {
    listingsView {
        PostItem()
    }
}
