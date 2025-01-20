package com.example.gui2_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidColumnMain()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidColumnMain() {
    val possiblePages = arrayOf("lister", "saisir", "regler")
    val shownPage = possiblePages[2]

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp) // Shadow on the bottom. Couldn't make it darker
            ) {
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(Color(0xFFE5810D)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowLeft, // Use Info arrow
//                    contentDescription = "Info arrow",
//                    tint = Color.White,
//                    modifier = Modifier
//                        .size(40.dp) // Size of the icon
//                        .padding(0.dp) // Padding inside the box
//
//                )
                }
            }

            if (shownPage == "lister") {
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = "ph", // Needed to avoid trouble but hidden
                        onValueChange = {},
                        label = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically, // Align the label vertically with the icon
                            ) {
                                // Icon next to the label
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Info Search",
                                    tint = Color.Gray,
                                    modifier = Modifier.padding(end = 4.dp) // Space between icon and label
                                )
                                // Label next to the icon
                                Text("Recherche")
                            }
                        },
                        enabled = false,
                        modifier = Modifier
                            .fillMaxWidth() // Didn't manage to remove internal padding
                            .padding(horizontal = 10.dp, vertical = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White, // White background for the TextField
                            disabledLabelColor = Color.Gray, // Color for the label when disabled
                            disabledTextColor = Color.Gray, // Color for the text when disabled
                            disabledIndicatorColor = Color.Gray // Remove the underline indicator color when disabled
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .height(70.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Icon(
                            modifier = Modifier.size(60.dp),
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Info desc",
                            tint = Color(0xFFE5810D),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(1.dp) // Vertical line
                            .fillMaxHeight()
                            .padding(vertical = 18.dp)
                            .background(Color(0xFFE5810D))
                    ) {}

                    class buttonOrder(
                        var name: String,
                        var colorText: Color,
                        var colorBackground: Color
                    )

                    val customButtonData = listOf(
                        buttonOrder("Coupe", Color.White, Color(0xFFE5810D)),
                        buttonOrder("Date", Color(0xFFE5810D), Color.White),
                        buttonOrder("Numéro", Color(0xFFE5810D), Color.White),
                        buttonOrder("Type", Color(0xFFE5810D), Color.White)
                    )

                    customButtonData.forEach { buttonData ->
                        Column(
                            modifier = Modifier
                                .border(1.dp, Color(0xFFE5810D), RoundedCornerShape(5.dp))
                                .height(24.dp)
                                .background(
                                    buttonData.colorBackground,
                                    RoundedCornerShape(5.dp)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "  " + buttonData.name + "  ",
                                color = buttonData.colorText,
                                fontSize = 16.sp
                            )
                        }
                    }
                }

                Row( // Just to make a line
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .background(Color.Gray)
                ) {}

                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(vertical = 10.dp)
                        .fillMaxWidth()
                ) {
                    LazyColumn(modifier = Modifier.padding(bottom = 90.dp)) {
                        class cardData(var date: String, var number: String, var cut: String)

                        val customButtonData = listOf(
                            cardData("15/07/2019", "9999", "Erddg234"),
                            cardData("01/07/2019", "999", "1"),
                            cardData("11/08/2019", "9129", "Er3ddg234"),
                            cardData("11/07/2012", "12", "ewade"),
                            cardData("11/07/2022", "4805", "feapif"),
                            cardData("11/07/1998", "22", "feapif")
                        )

                        items(customButtonData) { cardData ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth() // Ensure cards fill the width of the screen
                                    .padding(vertical = 4.dp) // Vertical padding between cards
                                    .border(1.dp, Color(0xFFE5810D), RoundedCornerShape(5.dp)),
                                elevation = CardDefaults.elevatedCardElevation(4.dp), // Elevation for shadow
                                colors = CardDefaults.cardColors(containerColor = Color.White) // White background color
                            ) {
                                Row(
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(end = 4.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {

                                        Image(
                                            painter = painterResource(R.drawable.log),
                                            contentDescription = "log",
                                            modifier = Modifier
                                                .size(75.dp)  // Set a fixed height for the image
                                        )
                                    }
                                    Column() {
                                        Row() {
                                            Column() {
                                                Row() {
                                                    Text(
                                                        "Date:",
                                                        color = Color.Gray,
                                                        fontSize = 13.sp
                                                    )
                                                }
                                                Row() {
                                                    Text(
                                                        cardData.date,
                                                        fontSize = 19.sp
                                                    )
                                                }
                                            }
                                        }
                                        Row() {
                                            Column() {
                                                Row() {
                                                    Text(
                                                        "Numéro:",
                                                        color = Color.Gray,
                                                        fontSize = 13.sp
                                                    )
                                                }
                                                Row() {
                                                    Text(
                                                        cardData.number,
                                                        fontSize = 19.sp
                                                    )
                                                }
                                            }
                                        }
                                    }


                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        Row(modifier = Modifier.fillMaxHeight()) {
                                            Column(horizontalAlignment = Alignment.End) {
                                                Row() {
                                                    Text(
                                                        "Coupe:",
                                                        color = Color.Gray,
                                                        fontSize = 13.sp
                                                    )
                                                }
                                                Row() {
                                                    Text(
                                                        cardData.cut,
                                                        fontSize = 19.sp
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (shownPage == "saisir") {
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .padding(bottom = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image( //Making an image since I don't know to make this without
                        painter = painterResource(R.drawable.donut),
                        contentDescription = "donut",
                        modifier = Modifier
                            .size(160.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .padding(top = 0.dp)
                ) {
                    class woodInfo(
                        var name: String,
                        var value: Double,
                        var colorPoint: Color,
                        var colorBackground: Color
                    )

                    val woodInfoOrder = listOf(
                        woodInfo("Epicéa", 247.8, Color.Yellow, Color(0xFFE5810D)),
                        woodInfo("Hêtre", 0.3, Color.Red, Color.White),
                        woodInfo("Résineux", 248.8, Color.Black, Color.White),
                        woodInfo("Cerisier", 1.4, Color.Green, Color.White),
                        woodInfo("Bouleau", 1.9, Color.Magenta, Color.White),
                        woodInfo("Feuillus", 3.6, Color.Blue, Color.White)
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        items(woodInfoOrder.size) { index ->
                            Box(
                                modifier = Modifier
                                    .border(1.dp, Color(0xFFE5810D), RoundedCornerShape(5.dp))
                                    .background(
                                        woodInfoOrder[index].colorBackground,
                                        RoundedCornerShape(5.dp),
                                    )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .padding(start = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .background(
                                                woodInfoOrder[index].colorPoint,
                                                RoundedCornerShape(25.dp)
                                            )
                                            .size(10.dp),
                                    )
                                    {}

                                    Column(modifier = Modifier.padding(start = 5.dp)) {
                                        Text(
                                            woodInfoOrder[index].name + " : " + woodInfoOrder[index].value.toString(),
                                            fontSize = 20.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    LazyVerticalGrid(
                        modifier = Modifier.padding(bottom = 90.dp),
                        columns = GridCells.Fixed(4),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        items(20) { index ->
                            Box(
                                modifier = Modifier
                                    .size(85.dp)
                                    .border(1.dp, Color(0xFFE5810D), RoundedCornerShape(5.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceEvenly,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        var shownIndex = index + 1

                                        Text(
                                            shownIndex.toString(),
                                            color = Color(0xFFE5810D),
                                            fontSize = 20.sp
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .background(
                                                Color(0xFFE5810D),
                                                RoundedCornerShape(25.dp)
                                            )
                                            .size(width = 50.dp, height = 40.dp),
                                        horizontalArrangement = Arrangement.SpaceEvenly,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            "34",
                                            color = Color.White,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            }
                        }
                    }


                }
            }

            if (shownPage == "regler") {
                Row() {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 20.dp)
                    ) {
                        Row {
                            TextField(
                                value = "17/07/2019",
                                onValueChange = {},
                                label = { Text("Date de cubage *") },
                                enabled = false,
                                modifier = Modifier // Didn't manage to remove internal padding
                                    .padding(
                                        horizontal = 10.dp,
                                        vertical = 10.dp
                                    ),
                                textStyle = TextStyle(
                                    color = Color.Black,
                                    fontSize = 18.sp
                                ),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                )
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp)
                    ) {
                        Row() {
                            TextField(
                                value = "9999",
                                onValueChange = {},
                                label = { Text("Numéro *") },
                                enabled = false,
                                modifier = Modifier // Didn't manage to remove internal padding
                                    .padding(
                                        horizontal = 10.dp,
                                        vertical = 10.dp
                                    ),
                                textStyle = TextStyle(
                                    color = Color.Black,
                                    fontSize = 18.sp
                                ),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                )
                            )
                        }
                    }
                }

                Row() {
                    Column() {
                        TextField(
                            value = "Erddg234",
                            onValueChange = {},
                            label = { Text("Coupe *") },
                            enabled = false,
                            modifier = Modifier
                                .fillMaxWidth() // Didn't manage to remove internal padding
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 10.dp
                                ),
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontSize = 18.sp
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                            )
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(bottom = 2.dp)
                        ) {
                            Text(
                                "Description *",
                                color = Color.Gray,
                                fontSize = 13.sp
                            )
                        }
                        Row() {
                            BasicTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .border(1.dp, Color.Gray, RoundedCornerShape(5.dp)),
                                value = "",
                                onValueChange = {}, // Update the value when text changes
                                textStyle = TextStyle(
                                    fontSize = 18.sp,
                                    color = Color.Black
                                ), // Set font size and color
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(bottom = 30.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(start = 14.dp, bottom = 2.dp)
                        ) {
                            Text(
                                "Format *",
                                color = Color.Gray,
                                fontSize = 13.sp
                            )
                        }
                        Row() {
                            RadioButton(
                                selected = false,
                                onClick = {},
                                modifier = Modifier.align(Alignment.CenterVertically),
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFFE5810D),
                                    unselectedColor = Color(0xFFE5810D)
                                )
                            )
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                text = "Pile",
                                fontSize = 18.sp
                            )
                        }
                        Row() {
                            RadioButton(
                                selected = true,
                                onClick = {},
                                modifier = Modifier.align(Alignment.CenterVertically),
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFFE5810D),
                                    unselectedColor = Color(0xFFE5810D)
                                )
                            )
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                text = "Tige",
                                fontSize = 18.sp
                            )
                        }
                        Row( // Just to make a line
                            modifier = Modifier
                                .height(1.dp)
                                .padding(horizontal = 10.dp)
                                .background(Color.Gray)
                                .fillMaxWidth()
                        ) {}
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(start = 12.dp, bottom = 2.dp)
                        ) {
                            Text(
                                "Ecorse *",
                                color = Color.Gray,
                                fontSize = 13.sp
                            )
                        }
                        Row() {
                            RadioButton(
                                selected = false,
                                onClick = {},
                                modifier = Modifier.align(Alignment.CenterVertically),
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFFE5810D),
                                    unselectedColor = Color(0xFFE5810D)
                                )
                            )
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                text = "Sur Ecorce",
                                fontSize = 18.sp
                            )
                        }
                        Row() {
                            RadioButton(
                                selected = true,
                                onClick = {},
                                modifier = Modifier.align(Alignment.CenterVertically),
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFFE5810D),
                                    unselectedColor = Color(0xFFE5810D)
                                )
                            )
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                text = "Ecorcée",
                                fontSize = 18.sp
                            )
                        }
                        Row( // Just to make a line
                            modifier = Modifier
                                .height(1.dp)
                                .padding(horizontal = 10.dp)
                                .background(Color.Gray)
                                .fillMaxWidth()
                        ) {}
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFB3261E)
                            ),
                            modifier = Modifier.width(160.dp)
                        ) {
                            Text(
                                "Annuler",
                                fontSize = 22.sp
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF009951)
                            ),
                            modifier = Modifier.width(160.dp)
                        ) {
                            Text(
                                "Enregistrer",
                                fontSize = 22.sp
                            )
                        }
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(100.dp)
                .shadow(4.dp) // Shadow on the top. Couldn't make it darker
        ) {
            Row( //Couldn't use a navigationBar at bottom since it required some xml changes
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFE5810D))
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                class menuIcon(
                    var icon: ImageVector,
                    var name: String,
                    var colorIcon: Color,
                    var colorBackground: Color
                )

                // List of custom text for the repeatable column
                val customIconData = listOf(
                    menuIcon(Icons.Default.List, "Lister", Color.Black, Color.White),
                    menuIcon(
                        Icons.Default.ExitToApp,
                        "Saisir",
                        Color.White,
                        Color(0xFFE5810D)
                    ), //Icon is the closed possible
                    menuIcon(
                        Icons.Default.AddCircle,
                        "Régler",
                        Color.White,
                        Color(0xFFE5810D)
                    ) //Icon is the closed possible
                )

                customIconData.forEach { dataIcon ->
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .background(
                                    dataIcon.colorBackground,
                                    RoundedCornerShape(50.dp)
                                )
                                .padding(
                                    horizontal = 6.dp,
                                    vertical = 4.dp
                                ) // Padding inside the box
                                .width(40.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = dataIcon.icon,
                                contentDescription = "Info desc",
                                tint = dataIcon.colorIcon
                            )
                        }

                        Text(dataIcon.name, color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidColumnMain()
}