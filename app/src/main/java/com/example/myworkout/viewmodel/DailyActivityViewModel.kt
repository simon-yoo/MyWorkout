package com.example.myworkout.viewmodel

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myworkout.model.DailyActivity
//import com.example.myworkout.NotificationReceiver
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class DailyActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _dailySchedules = MutableLiveData<List<DailyActivity>>()
    val dailySchedules: LiveData<List<DailyActivity>> = _dailySchedules

    fun getDailyActivities() {
        viewModelScope.launch {
            val dailySchedules = listOf(
                DailyActivity(
                    "MONDAY", listOf(
                        "30 minutes of cardio (running, cycling, or swimming)",
                        "15 minutes of core exercises (planks, crunches, leg raises)",
                        "15 minutes of stretching and cool down"
                    )
                ),
                DailyActivity(
                    "TUESDAY", listOf(
                        "20 minutes of upper body weightlifting (bench press, shoulder press, bicep curls)",
                        "20 minutes of bodyweight exercises (push-ups, pull-ups, dips)",
                        "20 minutes of stretching and cool down"
                    )
                ),
                DailyActivity(
                    "WEDNESDAY", listOf(
                        "60 minutes of yoga, focusing on flexibility and balance"
                    )
                ),
                DailyActivity(
                    "THURSDAY", listOf(
                        "20 minutes of lower body weightlifting (squats, deadlifts, lunges)",
                        "20 minutes of bodyweight exercises (squats, lunges, calf raises)",
                        "20 minutes of stretching and cool down"
                    )
                ),
                DailyActivity(
                    "SATURDAY", listOf(
                        "30 minutes of cardio",
                        "15 minutes of core strengthening exercises",
                        "15 minutes of stretching and cool down"
                    )
                )
            )

            _dailySchedules.value = dailySchedules


        }
    }

//    private fun scheduleNotification(context: Context, day: String) {
//        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        val intent = Intent(context, NotificationReceiver::class.java)
//        intent.putExtra("notificationTitle", "Time to Exercise")
//        intent.putExtra("notificationMessage", "It's time for your daily exercise routine!")
//
//        val calendar = Calendar.getInstance().apply {
//            timeInMillis = System.currentTimeMillis()
//            set(Calendar.HOUR_OF_DAY, 13) // Set the desired hour for the notification
//            set(Calendar.MINUTE, 57) // Set the desired minute for the notification (10 minutes before 1 PM)
//            set(Calendar.SECOND, 0)
//            add(Calendar.DAY_OF_WEEK, getDayOfWeek(day))
//        }
//
//        val pendingIntent = PendingIntent.getBroadcast(
//            context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//        )
//
//        alarmManager.setRepeating(
//            AlarmManager.RTC_WAKEUP,
//            calendar.timeInMillis,
//            AlarmManager.INTERVAL_DAY * 7, // Repeat weekly
//            pendingIntent
//        )
//    }
//
//    private fun getDayOfWeek(day: String): Int {
//        return when (day.uppercase(Locale.getDefault())) {
//            "SUNDAY" -> Calendar.SUNDAY
//            "MONDAY" -> Calendar.MONDAY
//            "TUESDAY" -> Calendar.TUESDAY
//            "WEDNESDAY" -> Calendar.WEDNESDAY
//            "THURSDAY" -> Calendar.THURSDAY
//            "FRIDAY" -> Calendar.FRIDAY
//            "SATURDAY" -> Calendar.SATURDAY
//            else -> Calendar.SUNDAY
//        }
//    }
}
