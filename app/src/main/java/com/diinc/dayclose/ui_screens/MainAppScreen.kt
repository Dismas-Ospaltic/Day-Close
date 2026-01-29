package com.diinc.dayclose.ui_screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diinc.dayclose.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



@Composable
fun MainAppScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            // 👇 This background will go BEHIND the status bar
            .background(colorResource(id = R.color.gray))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()

                // 👇 THIS is the key line
                // It pushes CONTENT below the status bar
                .statusBarsPadding()

                // Scrollable content
                .verticalScroll(rememberScrollState())

                // Your own spacing
                .padding(horizontal = 12.dp, vertical = 16.dp)
        ) {

            GreetingHeader(
                userName = "Diinc Solutions",
                onProfileClick = {
                    navController.navigate("settings")
                }
            )

            // other UI elements...
        }
    }
}






@Preview(showBackground = true)
@Composable
fun MainAppScreenPreview() {
    MainAppScreen(navController = rememberNavController())
}




@Composable
fun GreetingHeader(
    userName: String,
    onProfileClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.gray))
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 12.dp
            )
    ) {

        // LEFT SIDE TEXT
        Column(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "Good morning!",
                fontSize = 14.sp,
                color = colorResource(id = R.color.oxford_navy)
            )

            Text(
                text = userName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.seaweed)
            )
        }

        // RIGHT SIDE USER ICON
        IconButton(
            onClick = onProfileClick,
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "User profile",
                tint = colorResource(id = R.color.seaweed),
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
