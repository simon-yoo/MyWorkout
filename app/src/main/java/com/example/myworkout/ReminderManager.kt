//import android.app.AlarmManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import androidx.annotation.RequiresApi
//import java.util.Calendar
//
//import com.example.myworkout.com.example.myworkout.AlarmReceiver
//import java.util.Locale
//
//object RemindersManager {
//    const val REMINDER_NOTIFICATION_REQUEST_CODE = 123
//
//    @RequiresApi(Build.VERSION_CODES.S)
//    fun startReminder(
//        context: Context,
//        reminderTime: String = "08:00",
//        reminderId: Int = REMINDER_NOTIFICATION_REQUEST_CODE
//    ) {
//        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//        val (hours, min) = reminderTime.split(":").map { it.toInt() }
//        val intent = Intent(context.applicationContext, AlarmReceiver::class.java).let { intent ->
//            PendingIntent.getBroadcast(
//                context.applicationContext,
//                reminderId,
//                intent,
//                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//            )
//        }
//
//        val calendar: Calendar = Calendar.getInstance(Locale.ENGLISH).apply {
//            set(Calendar.HOUR_OF_DAY, hours)
//            set(Calendar.MINUTE, min)
//        }
//
//        // If the trigger time you specify is in the past, the alarm triggers immediately.
//        // If so, just add one day to the required calendar
//        // Note: I'm also adding one minute because if the user clicked on the notification as soon as
//        // he receives it, it will reschedule the alarm to fire another notification immediately
//        if (Calendar.getInstance(Locale.ENGLISH)
//                .apply { add(Calendar.MINUTE, 1) }.timeInMillis - calendar.timeInMillis > 0
//        ) {
//            calendar.add(Calendar.DATE, 1)
//        }
//
//        // Check for SCHEDULE_EXACT_ALARM permission
//        if (alarmManager.canScheduleExactAlarms()) {
//            alarmManager.setExactAndAllowWhileIdle(
//                AlarmManager.RTC_WAKEUP,
//                calendar.timeInMillis,
//                intent
//            )
//        } else {
//            // Handle case where SCHEDULE_EXACT_ALARM permission is not granted
//            // You may want to use setExact or request the permission from the user
//            // or use an inexact alarm as a fallback
//            alarmManager.setExact(
//                AlarmManager.RTC_WAKEUP,
//                calendar.timeInMillis,
//                intent
//            )
//        }
//    }
//
//    fun stopReminder(
//        context: Context,
//        reminderId: Int = REMINDER_NOTIFICATION_REQUEST_CODE
//    ) {
//        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        val intent = Intent(context, AlarmReceiver::class.java).let { intent ->
//            PendingIntent.getBroadcast(
//                context,
//                reminderId,
//                intent,
//                PendingIntent.FLAG_IMMUTABLE
//            )
//        }
//        alarmManager.cancel(intent)
//    }
//}
