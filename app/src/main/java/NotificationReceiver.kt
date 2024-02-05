//package com.example.myworkout
//
//import android.Manifest
//import android.app.Activity
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.os.Build
//import android.util.Log
//import androidx.core.app.ActivityCompat
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import androidx.core.content.ContextCompat
//import com.example.workout.R
//
//class NotificationReceiver : BroadcastReceiver() {
//
//    override fun onReceive(context: Context, intent: Intent) {
//        // Check if the received intent has the expected action
//        if (intent.action == "com.example.myworkout.SHOW_NOTIFICATION") {
//            // Log the action for debugging
//            Log.d("NotificationReceiver", "Received broadcast")
//            // You can remove this in the final version
//            println("Received SHOW_NOTIFICATION action")
//
//            // Check if the app has the necessary notification permission
//            if (hasNotificationPermission(context)) {
//                println("Notification permission granted")
//                createNotificationChannel(context)
//                showNotification(
//                    context,
//                    "Workout Reminder",
//                    "Your workout is scheduled in 10 minutes!"
//                )
//            } else {
//                println("Notification permission denied")
//            }
//        }
//    }
//
//    private fun createNotificationChannel(context: Context) {
//        // Check if the notification channel already exists
//        val channelId = "workout_channel"
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val notificationManager =
//                context.getSystemService(NotificationManager::class.java)
//            val channel = NotificationChannel(
//                channelId,
//                "Workout Channel",
//                NotificationManager.IMPORTANCE_DEFAULT
//            )
//            notificationManager.createNotificationChannel(channel)
//        }
//    }
//
//    private fun showNotification(context: Context, title: String, content: String) {
//        val builder = NotificationCompat.Builder(context, "workout_channel")
//            .setSmallIcon(R.drawable.ic_notification)
//            .setContentTitle(title)
//            .setContentText(content)
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//        val notificationManager = NotificationManagerCompat.from(context)
//        if (ContextCompat.checkSelfPermission(
//                context,
//                Manifest.permission.VIBRATE
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // Request the vibration permission
//            requestVibrationPermission(context)
//        } else {
//            notificationManager.notify(1, builder.build())
//        }
//    }
//
//    private fun hasNotificationPermission(context: Context): Boolean {
//        val notificationPermission = Manifest.permission.VIBRATE
//        return ContextCompat.checkSelfPermission(
//            context,
//            notificationPermission
//        ) == PackageManager.PERMISSION_GRANTED
//    }
//
//    private fun requestVibrationPermission(context: Context) {
//        // Request the vibration permission
//        ActivityCompat.requestPermissions(
//            context as Activity,
//            arrayOf(Manifest.permission.VIBRATE),
//            1
//        )
//    }
//}
