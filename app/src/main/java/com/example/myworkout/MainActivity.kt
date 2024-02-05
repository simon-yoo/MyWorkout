package com.example.myworkout

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.myworkout.view.DailyActivityScreen
import com.example.myworkout.viewmodel.DailyActivityViewModel
import com.example.workout.R

class MainActivity : ComponentActivity() {
    private val viewModel: DailyActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        createNotificationsChannels()
//        RemindersManager.startReminder(this)

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                DailyActivityScreen(viewModel)
            }
        }
    }

//    private fun createNotificationsChannels() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                getString(R.string.reminders_notification_channel_id),
//                getString(R.string.reminders_notification_channel_name),
//                NotificationManager.IMPORTANCE_HIGH
//            )
//            ContextCompat.getSystemService(this, NotificationManager::class.java)
//                ?.createNotificationChannel(channel)
//        }
//    }
}
