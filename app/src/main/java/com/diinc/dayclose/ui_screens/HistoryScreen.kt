//package com.diinc.dayclose.ui_screens
//
//
//import android.R.attr.background
//import android.R.attr.padding
//import android.graphics.Paint
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import com.diinc.dayclose.R
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalLayoutDirection
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.ui.graphics.toArgb
//import kotlinx.coroutines.launch
//
//
//
//
//import androidx.compose.ui.graphics.toArgb
//import com.patrykandpatrick.vico.compose.component.lineComponent
//import com.patrykandpatrick.vico.compose.component.overlayingComponent
//import com.patrykandpatrick.vico.compose.component.shapeComponent
//import com.patrykandpatrick.vico.compose.component.textComponent
//
//
//
//import com.patrykandpatrick.vico.core.component.shape.Shapes
//import com.patrykandpatrick.vico.compose.component.shapeComponent
//import com.patrykandpatrick.vico.compose.component.lineComponent
//import com.patrykandpatrick.vico.core.chart.values.AxisValuesOverrider
//
//import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
//import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
//import com.patrykandpatrick.vico.compose.chart.Chart
//import com.patrykandpatrick.vico.compose.chart.line.lineChart
//import com.patrykandpatrick.vico.compose.component.lineComponent
//import com.patrykandpatrick.vico.compose.component.shape.dashedShape
//import com.patrykandpatrick.vico.compose.component.shapeComponent
//import com.patrykandpatrick.vico.compose.component.textComponent
//import com.patrykandpatrick.vico.core.DefaultDimens
//import com.patrykandpatrick.vico.core.chart.DefaultPointConnector
//import com.patrykandpatrick.vico.core.chart.line.LineChart
//import com.patrykandpatrick.vico.core.chart.line.LineChart.LineSpec
//import com.patrykandpatrick.vico.core.component.marker.MarkerComponent
//import com.patrykandpatrick.vico.core.component.text.VerticalPosition
//import com.patrykandpatrick.vico.core.component.text.textComponent
//import com.patrykandpatrick.vico.core.entry.ChartEntry
//import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
//import com.patrykandpatrick.vico.core.formatter.DecimalFormatValueFormatter
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HistoryScreen(navController: NavController) {
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.gray))
//            // 👇 THIS is the key line
//            // It pushes CONTENT below the status bar
//            .statusBarsPadding()
//            .verticalScroll(rememberScrollState())
//            .padding(horizontal = 12.dp, vertical = 16.dp)
//    ) {
//
//        HistIntroHeader()
//
//        val pagerState = rememberPagerState(
//            initialPage = 0,
//            pageCount = { TimeRange.entries.size }
//        )
//
//        val coroutineScope = rememberCoroutineScope()
//
//        Column {
//            // Toggle Buttons
//            TimeRangeToggle(
//                selectedIndex = pagerState.currentPage,
//                onSelected = { index ->
//                    coroutineScope.launch {
//                        pagerState.animateScrollToPage(index)
//                    }
//                }
//            )
//
//            // Pager
//            HorizontalPager(
//                state = pagerState,
//                modifier = Modifier.fillMaxWidth()
//            ) { page ->
//
//                when (TimeRange.entries[page]) {
//                    TimeRange.WEEKLY -> {
//                        NetProfitLineChart(
//                            data = listOf(18000f, 12000f, -3000f, 4000f, 13000f, 8000f, 11000f),
//                            labels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
//                        )
//                    }
//
//                    TimeRange.MONTHLY -> {
//                        NetProfitLineChart(
//                            data = listOf(120000f, 98000f, 140000f, -20000f),
//                            labels = listOf("Week 1", "Week 2", "Week 3", "Week 4")
//                        )
//                    }
//
//                    TimeRange.YEARLY -> {
//                        NetProfitLineChart(
//                            data = listOf(900000f, 1100000f, 850000f, 1300000f),
//                            labels = listOf("Q1", "Q2", "Q3", "Q4")
//                        )
//                    }
//                }
//            }
//        }
//
//
//    }
//}
//
//
//
//
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun HistoryScreenPreview() {
//    HistoryScreen(navController = rememberNavController())
//}
//
//
//
//@Composable
//fun HistIntroHeader(
//) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(colorResource(id = R.color.light_background),
//                shape = RoundedCornerShape(16.dp)
//            )
//            .padding(
//                top = 16.dp,
//                start = 16.dp,
//                end = 16.dp,
//                bottom = 12.dp
//            )
//
//    ) {
//
//        // LEFT SIDE TEXT
//        Column(
//            modifier = Modifier.align(Alignment.CenterStart)
//        ) {
//
//            Text(
//                text = "Summary Data",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = colorResource(id = R.color.seaweed)
//            )
//            Text(
//                text = "View summary and History data.",
//                fontSize = 14.sp,
//                color = colorResource(id = R.color.oxford_navy)
//            )
//        }
//
//    }
//}
//
//
//
//
//
////Segmented Toggle (Top Buttons)
//@Composable
//fun TimeRangeToggle(
//    selectedIndex: Int,
//    onSelected: (Int) -> Unit
//) {
//    val options = TimeRange.values()
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        options.forEachIndexed { index, option ->
//            Button(
//                onClick = { onSelected(index) },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = if (index == selectedIndex)
//                        MaterialTheme.colorScheme.primary
//                    else
//                        MaterialTheme.colorScheme.surface
//                ),
//                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
//                shape = RoundedCornerShape(20.dp)
//            ) {
//                Text(
//                    text = option.title,
//                    color = if (index == selectedIndex)
//                        MaterialTheme.colorScheme.onPrimary
//                    else
//                        MaterialTheme.colorScheme.primary
//                )
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
//
//////Reusable Line Chart (Updated)
//
//
//@Composable
//fun NetProfitLineChart(
//    data: List<Float>,
//    labels: List<String>
//) {
//    val modelProducer = remember(data) {
//        ChartEntryModelProducer(
//            data.mapIndexed { index, value ->
//                object : ChartEntry {
//                    override val x = index.toFloat()
//                    override val y = value
//                    override fun withY(y: Float): ChartEntry {
//                        TODO("Not yet implemented")
//                    }
//                }
//            }
//        )
//    }
//
//    Chart(
//        chart = lineChart(
//            lines = listOf(
//                LineSpec(
//                    lineColor = Color(0xFF2E7D32).toArgb(),
//                    lineThicknessDp = 3f,
//                    lineCap = Paint.Cap.ROUND,
//                    pointSizeDp = 10f, // Set a fixed size or use DefaultDimens
//                    dataLabelVerticalPosition = VerticalPosition.Top,
//                    dataLabelValueFormatter = DecimalFormatValueFormatter(),
//                    // Fixed: Replaced cubicStrength variable with a literal 0.2f
//                    pointConnector = DefaultPointConnector(cubicStrength = 0.2f),
//                )
//            )
//        ),
//        chartModelProducer = modelProducer,
//        startAxis = rememberStartAxis(),
//        bottomAxis = rememberBottomAxis(
//            valueFormatter = { value, _ ->
//                labels.getOrNull(value.toInt()) ?: ""
//            }
//        ),
//        marker = rememberMarker(),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(260.dp)
//            .padding(16.dp)
//    )
//}
//
//
////@Composable
////fun rememberMarker(): com.patrykandpatrick.vico.core.marker.Marker {
////    val label = textComponent {
////        color = Color.White.toArgb()
////        background = shapeComponent(Shapes.pillShape, Color.Black)
////        padding = com.patrykandpatrick.vico.core.dimensions.MutableDimensions(4f, 8f, 4f, 8f)
////    }
////    val indicator = shapeComponent(Shapes.pillShape, Color(0xFF2E7D32))
////    val guideline = lineComponent(Color.LightGray, 2f, Shapes.dashedShape(8f, 4f))
////
////    return rememberMarkerComponent(
////        label = label,
////        indicator = indicator,
////        guideline = guideline,
////    )
////}
//
//
//@Composable
//fun rememberMarker(): MarkerComponent {
//    val label = textComponent {
//        color = Color.White.toArgb()
//        background = shapeComponent(Shapes.rectShape(CornerSize.Pill), Color.Black)
//        padding = com.patrykandpatrick.vico.core.dimensions.MutableDimensions(4f, 8f, 4f, 8f)
//    }
//
//    val indicator = shapeComponent(Shapes.pillShape, Color(0xFF2E7D32))
//
//    val guideline = lineComponent(
//        color = Color.LightGray,
//        thicknessDp = 2f,
//        shape = Shapes.dashedShape(8f, 4f)
//    )
//
//    return MarkerComponent(
//        label = label,
//        indicator = indicator,
//        guideline = guideline
//    )
//}
//
//
//
//enum class TimeRange(val title: String) {
//    WEEKLY("Weekly"),
//    MONTHLY("Monthly"),
//    YEARLY("Yearly")
//}


package com.diinc.dayclose.ui_screens

import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.diinc.dayclose.R
import kotlinx.coroutines.launch

// Vico Imports
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.component.lineComponent
import com.patrykandpatrick.vico.compose.component.shape.dashedShape
import com.patrykandpatrick.vico.compose.component.shapeComponent
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.core.chart.DefaultPointConnector
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.component.marker.MarkerComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.text.VerticalPosition
import com.patrykandpatrick.vico.core.component.text.textComponent
import com.patrykandpatrick.vico.core.dimensions.MutableDimensions
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryOf
import com.patrykandpatrick.vico.core.formatter.DecimalFormatValueFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray))
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        HistIntroHeader()

        val pagerState = rememberPagerState(
            initialPage = 0,
            pageCount = { TimeRange.entries.size }
        )
        val coroutineScope = rememberCoroutineScope()

        Column {
            // Toggle Buttons
            TimeRangeToggle(
                selectedIndex = pagerState.currentPage,
                onSelected = { index ->
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )

            // Pager
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                when (TimeRange.entries[page]) {
                    TimeRange.WEEKLY -> {
                        NetProfitLineChart(
                            data = listOf(18000f, 12000f, -3000f, 4000f, 13000f, 8000f, 11000f),
                            labels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                        )
                    }
                    TimeRange.MONTHLY -> {
                        NetProfitLineChart(
                            data = listOf(120000f, 98000f, 140000f, -20000f),
                            labels = listOf("Week 1", "Week 2", "Week 3", "Week 4")
                        )
                    }
                    TimeRange.YEARLY -> {
                        NetProfitLineChart(
                            data = listOf(900000f, 1100000f, 850000f, 1300000f),
                            labels = listOf("Q1", "Q2", "Q3", "Q4")
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NetProfitLineChart(
    data: List<Float>,
    labels: List<String>
) {
    // entryOf creates a proper FloatEntry that won't crash on touch/animation
    val modelProducer = remember(data) {
        ChartEntryModelProducer(
            data.mapIndexed { index, value -> entryOf(index.toFloat(), value) }
        )
    }

    Chart(
        chart = lineChart(
            lines = listOf(
                LineChart.LineSpec(
                    lineColor = Color(0xFF2E7D32).toArgb(),
                    lineThicknessDp = 3f,
                    lineCap = Paint.Cap.ROUND,
                    pointSizeDp = 8f,
                    dataLabelVerticalPosition = VerticalPosition.Top,
                    dataLabelValueFormatter = DecimalFormatValueFormatter(),
                    pointConnector = DefaultPointConnector(cubicStrength = 0.2f),
                )
            )
        ),
        chartModelProducer = modelProducer,
        startAxis = rememberStartAxis(),
        bottomAxis = rememberBottomAxis(
            valueFormatter = { value, _ ->
                labels.getOrNull(value.toInt()) ?: ""
            }
        ),
        marker = rememberMarker(),
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(16.dp)
    )
}

//@Composable
//fun rememberMarker(): MarkerComponent {
//    val label = textComponent {
//        color = Color.White.toArgb()
//        background = shapeComponent(shape = Shapes.pillShape, color = Color.Black)
//        padding = MutableDimensions(4f, 8f, 4f, 8f)
//    }
//
//    val indicator = shapeComponent(Shapes.pillShape, Color(0xFF2E7D32))
//
//    val guideline = lineComponent(
//        color = Color.LightGray,
//        thicknessDp = 2f,
//        shape = Shapes.dashedShape(8f, 4f)
//    )
//
//    return remember(label, indicator, guideline) {
//        MarkerComponent(
//            label = label,
//            indicator = indicator,
//            guideline = guideline
//        )
//    }
//}


@Composable
fun rememberMarker(): MarkerComponent {
    val label = textComponent {
        color = Color.White.toArgb()
        background = shapeComponent(shape = Shapes.pillShape, color = Color.Black)
        padding = MutableDimensions(4f, 8f, 4f, 8f) // Core uses Float for dimensions
    }

    val indicator = shapeComponent(Shapes.pillShape, Color(0xFF2E7D32))

    val guideline = lineComponent(
        color = Color.LightGray,
        thickness = 2.dp, // Fixed name and type
        shape = Shapes.dashedShape(
            shape = Shapes.rectShape,
            dashLength = 8.dp,
            gapLength = 4.dp
        )
    )

    return remember(label, indicator, guideline) {
        MarkerComponent(
            label = label,
            indicator = indicator,
            guideline = guideline
        )
    }
}

@Composable
fun TimeRangeToggle(
    selectedIndex: Int,
    onSelected: (Int) -> Unit
) {
    val options = TimeRange.entries

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        options.forEachIndexed { index, option ->
            Button(
                onClick = { onSelected(index) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (index == selectedIndex)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = option.title,
                    color = if (index == selectedIndex)
                        MaterialTheme.colorScheme.onPrimary
                    else
                        MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun HistIntroHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                colorResource(id = R.color.light_background),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.align(Alignment.CenterStart)) {
            Text(
                text = "Summary Data",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.seaweed)
            )
            Text(
                text = "View summary and history data.",
                fontSize = 14.sp,
                color = colorResource(id = R.color.oxford_navy)
            )
        }
    }
}

enum class TimeRange(val title: String) {
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    YEARLY("Yearly")
}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    HistoryScreen(navController = rememberNavController())
}