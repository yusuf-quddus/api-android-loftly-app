package com.example.loftly

import android.graphics.Paint
import android.os.Bundle
import android.widget.Checkable
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.core.Text
import androidx.ui.material.surface.Card
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import java.time.format.TextStyle
import androidx.ui.core.Text as Text1

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val list = ArrayList<ListingPost>()
        list.add(ListingPost(
            image = R.drawable.house2,
            address = "555 Terrace Point",
            cost = "$4,400",
            datePosted = "Oct 24, 2019",
            name = "Papa John",
            profilePic = R.drawable.profile2,
            title = "Property Owner"))
        list.add(ListingPost(
            image = R.drawable.house3,
            address = "666 Hell Highway",
            cost = "$2,500",
            datePosted = "Oct 24, 2019",
            name = "Prajeet Patel",
            profilePic = R.drawable.profile1,
            title = "Landlord"))
        list.add(ListingPost(
            image = R.drawable.house4,
            address = "1212 Vogel Ct",
            cost = "$3,000",
            datePosted = "Oct 24, 2019",
            name = "Stacey Abrams",
            profilePic = R.drawable.profile3,
            title = "Organization"))

        setContent {
            listingsView {
                AllListings(list)
            }
        }
    }
}



/*
listingView:
    Main function outputs favorite listing page
 */
@Composable
fun listingsView(children: @Composable() () -> Unit) {
    children()
}




/*
AllListings:
    Holds All Favorite Listings of the page
 */
@Composable
fun AllListings(list:ArrayList<ListingPost>) {
    VerticalScroller() {
        Column {
            PageTitle()
            for(item in list) {
                PostItem(post = item)
            }
        }
    }
}




/*
*/
@Composable
fun PageTitle() {
    Container(modifier = Spacing(left = 5.dp, top = 2.dp, bottom = 2.dp, right = 5.dp)) {
        FlowRow(
            mainAxisSize = LayoutSize.Expand,
            mainAxisAlignment = MainAxisAlignment.Center
            // crossAxisAlignment = FlowCrossAxisAlignment.Center
        )  {
            Text(
                // Monthly Rental Cost
                text = "Favorite Listings",
                style = androidx.ui.text.TextStyle(fontSize = 24.sp, color = Color.Black, fontWeight = FontWeight.W500)
            )
        }

    }
}




/*
PostItem:
    A listing post with an image of listing
    and information about the listing
 */
@Composable
fun PostItem(post:ListingPost) {
    Ripple(bounded = true) {
        Container(modifier = Spacing(top = 4.dp, bottom = 4.dp)) {
            Card(elevation = 2.dp) {
                Padding(padding = 12.dp) {
                    Column {
                        listingImage(image = post.image);
                        listingInfo(post)
                    }
                }
            }
        }
    }
}




/*
listingImage:
    Shows image of listing property
 */
@Composable
fun listingImage(image:Int) {
    Container(expanded = true, height = 180.dp) {
        var houseImage = +imageResource(image)
        DrawImage(houseImage)
    }
}




/*
listingInfo:
    Shows info about listing property including
    address and author info
 */
@Composable
fun listingInfo(post: ListingPost) {
    HeightSpacer(height = 16.dp)
    Address(post.address)
    HeightSpacer(height = 16.dp)
    FlowRow(
        mainAxisSize = LayoutSize.Expand,
        mainAxisAlignment = MainAxisAlignment.SpaceBetween,
        crossAxisAlignment = FlowCrossAxisAlignment.Center
    )  {
        AuthorInfo(post)
    }
}




/*
Address:
    Location of listing property
 */
@Composable
fun Address(address:String) {
    Text(
        text = address,
        style = androidx.ui.text.TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
    )
}




/*
AuthorInfo:
    Listing Author profile image, name and title and posting info
 */
@Composable
fun AuthorInfo(post: ListingPost) {
    Column() {
        Row() {
            Container(width = 40.dp, height = 40.dp) {
                Clip(shape = CircleShape) {
                    DrawImage(image = +imageResource(post.profilePic))
                }
            }
            Column(modifier = Spacing(left = 8.dp)) {
                Text(
                    text = post.name,
                    style = androidx.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600
                    )
                )
                HeightSpacer(height = 2.dp)
                Text(
                    text = post.title,
                    style = androidx.ui.text.TextStyle(
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                )
            }
        }
        ButtonListing(2)
    }
    Column {
        Text(
            // Monthly Rental Cost
            text = post.cost,
            style = androidx.ui.text.TextStyle(fontSize = 14.sp, color = Color.DarkGray)
        )
        Text(
            // Posted Date
            text = post.datePosted,
            style = androidx.ui.text.TextStyle(fontSize = 14.sp, color = Color.DarkGray))
        // ButtonListing(2)
    }
}




/*
 */
@Composable
fun ButtonListing(choice:Int) {
    if(choice == 1)
        Container(modifier = Spacing(top = 10.dp, bottom = 4.dp)) {
            Button(text = "View Listing",modifier = Spacing(top = 5.dp), style = OutlinedButtonStyle(
                Border(color = Color.Green, width = 1.dp),
                shape = RoundedCornerShape(20),
                contentColor = Color.Green
            ))
        }
    else if (choice == 2)
        Container(modifier = Spacing(top = 10.dp, bottom = 4.dp)) {
            Button(text = "Remove",modifier = Spacing(top = 5.dp), style = OutlinedButtonStyle(
                Border(color = Color.Red, width = 1.dp),
                shape = RoundedCornerShape(40),
                contentColor = Color.Red
            ))
        }
}



/*
DefaultPreview:
    Preview code on android device
 */
@Preview
@Composable
fun DefaultPreview() {

    val list = ArrayList<ListingPost>()
    list.add(ListingPost(
        image = R.drawable.house2,
        address = "555 Terrace Point",
        cost = "4,400",
        datePosted = "Oct 24, 2019",
        name = "Papa John",
        profilePic = R.drawable.profile2,
        title = "Property Owner"))
    list.add(ListingPost(
        image = R.drawable.house3,
        address = "666 Hell Highway",
        cost = "2,500",
        datePosted = "Oct 24, 2019",
        name = "Prajeet Patel",
        profilePic = R.drawable.profile1,
        title = "Landlord"))
    list.add(ListingPost(
        image = R.drawable.house4,
        address = "1212 Vogel Ct",
        cost = "3,000",
        datePosted = "Oct 24, 2019",
        name = "Stacey Abrams",
        profilePic = R.drawable.profile3,
        title = "Organization"))


    listingsView {
        AllListings(list)
    }
}