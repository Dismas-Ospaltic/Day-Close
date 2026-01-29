package com.diinc.dayclose.ui_screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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


            CashSummaryRow(
                openingCash = "KES 12,500",
                closingCash = "KES 18,300"
            )


            ExpectedProfitCashCard(
                amount="Kes 20000",
            )

            DayActionsRow(
                onAddExpense = {
                    // navigate to Add Expense screen
                },
                onCloseDay = {
                    // handle day closing logic
                }
            )

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
                text = rememberGreeting(),
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


@Composable
fun CashSummaryRow(
    openingCash: String,
    closingCash: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        CashCard(
            title = "Opening Cash",
            amount = openingCash,
            backgroundColor = R.color.light_background,
            modifier = Modifier.weight(1f)
        )

        CashCard(
            title = "Closing Cash",
            amount = closingCash,
            backgroundColor = R.color.light_background,
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun CashCard(
    title: String,
    amount: String,
    backgroundColor: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = colorResource(id = backgroundColor),
                shape = RoundedCornerShape(20.dp)   // slightly rounder
            )
            .padding(20.dp)                         // ✅ BIG inner padding
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                color = colorResource(id = R.color.oxford_navy),
                fontSize = 16.sp                    // bigger label
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = amount,
                color = colorResource(id = R.color.oxford_navy),
                fontSize = 26.sp,                   // bigger amount
                fontWeight = FontWeight.Bold
            )
        }
    }
}




@Composable
fun ExpectedProfitCashCard(
    amount: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()                    // ✅ takes full screen width
            .padding(horizontal = 16.dp)       // ✅ outer spacing from screen edges
            .background(
                color = colorResource(id = R.color.light_background),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(24.dp)                    // ✅ big inner padding
    ) {
        Column {
            Text(
                text = "Expected Net Profit",
                color = colorResource(id=R.color.seaweed),
                fontSize = 16.sp                // slightly bigger label
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = amount,
                color = colorResource(id = R.color.yale_blue),
                fontSize = 28.sp,               // big emphasis
                fontWeight = FontWeight.Bold
            )
        }
    }
}


//action buttons
@Composable
fun ActionButton(
    text: String,
    icon: ImageVector,
    backgroundColor: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(56.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = backgroundColor)
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color.White
            )

            Text(
                text = text,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


@Composable
fun DayActionsRow(
    onAddExpense: () -> Unit,
    onCloseDay: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        ActionButton(
            text = "Add Expense",
            icon = Icons.Default.Create,
            backgroundColor = R.color.seaweed,
            onClick = onAddExpense,
            modifier = Modifier.weight(1f)
        )

        ActionButton(
            text = "Close Day",
            icon = Icons.Default.Lock,
            backgroundColor = R.color.oxford_navy,
            onClick = onCloseDay,
            modifier = Modifier.weight(1f)
        )
    }
}




@Composable
fun rememberGreeting(): String {
    var greeting by remember { mutableStateOf(getGreeting()) }

    LaunchedEffect(Unit) {
        while (true) {
            greeting = getGreeting()
            kotlinx.coroutines.delay(60_000) // update every minute
        }
    }

    return greeting
}

