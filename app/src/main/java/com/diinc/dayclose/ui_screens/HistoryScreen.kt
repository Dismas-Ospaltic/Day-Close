package com.diinc.dayclose.ui_screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diinc.dayclose.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(navController: NavController) {
//    val backgroundColor = colorResource(id = R.color.punch_red)
//    StatusBarColor(backgroundColor)

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)          // ✅ handles system insets
                .background(colorResource(id = R.color.gray))
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 12.dp)    // ✅ your own content padding
        ) {
            // Your screen content here


            Text("hello this is my history screen")
        }
    }
}







@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    HistoryScreen(navController = rememberNavController())
}