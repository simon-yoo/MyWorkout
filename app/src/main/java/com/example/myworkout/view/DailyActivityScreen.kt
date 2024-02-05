package com.example.myworkout.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myworkout.model.DailyActivity
import com.example.myworkout.viewmodel.DailyActivityViewModel


@Composable
fun DailyActivityScreen(viewModel: DailyActivityViewModel) {
    val dailyActivities by viewModel.dailySchedules.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.getDailyActivities()
    }

// display with scrolls
    LazyColumn {
        item {
            dailyActivities?.let {
                if (it.isNotEmpty()) {
                    DailyItem(it)
                } else {
                    // Handle case where data is empty
                    Text(text = "No daily activities available.")
                }
            }
        }
    }
}


// displays each card of daily activities
@Composable
fun DailyItem(dailyActivities: List<DailyActivity>) {
    for (activities in dailyActivities) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "DAY: ${activities.day}",
                    style = MaterialTheme.typography.body1,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(8.dp))
                for (activity in activities.activities) {
                    Text(
                        text = "Activity: $activity",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}