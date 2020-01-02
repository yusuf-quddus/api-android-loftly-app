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
fun PostItem() {
    Card() {
        Padding(padding = 8.dp) {
           Column() {
               Container(expanded = true, height = 180.dp) {
                   var image = +imageResource(R.drawable.house2)
                   DrawImage(image)
               }
               HeightSpacer(height = 16.dp)
               Text(
                   "555 Terrace Point",
                   style = androidx.ui.text.TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
               )

               HeightSpacer(height = 16.dp)
               Row() {
                   Row() {
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
                           style = androidx.ui.text.TextStyle(fontSize = 14.sp, color = Color.LightGray)
                       )
                       Text(
                           text = "200 Applicants",
                           style = androidx.ui.text.TextStyle(fontSize = 14.sp, color = Color.LightGray))

                   }

               }
           }
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
