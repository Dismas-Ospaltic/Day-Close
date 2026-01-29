package com.diinc.dayclose.ui_screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diinc.dayclose.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.diinc.dayclose.utils.getGreeting
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.FileInvoiceDollar


//@Composable
//fun DailyExpenseScreen(navController: NavController) {
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            // 👇 This background will go BEHIND the status bar
//            .background(colorResource(id = R.color.gray))
//    ) {
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//
//                // 👇 THIS is the key line
//                // It pushes CONTENT below the status bar
//                .statusBarsPadding()
//
//                // Scrollable content
//                .verticalScroll(rememberScrollState())
//
//                // Your own spacing
//                .padding(horizontal = 12.dp, vertical = 16.dp)
//        ) {
//
//            ExpenseHeader(
//                date="29/01/2026",
//            )
//
//
//
//
//
//
//
//        }
//    }
//}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyExpenseScreen(navController: NavController, dateId: String) {

    val backgroundColor = colorResource(id = R.color.seaweed)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Expense Details", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                        start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    bottom = innerPadding.calculateBottomPadding() + 80.dp
                )
                .background(colorResource(id = R.color.gray))
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            ExpenseHeader(
                date=dateId,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DailyExpenseScreenPreview() {
    DailyExpenseScreen(navController = rememberNavController(),"2026/01/03")
}


@Composable
fun ExpenseHeader(
    date: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.light_background),
                shape = RoundedCornerShape(16.dp)
            )
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
                text = "Daily Expenses for:",
                fontSize = 14.sp,
                color = colorResource(id = R.color.oxford_navy)
            )

            Text(
                text = date,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.seaweed)
            )
        }

    }
}