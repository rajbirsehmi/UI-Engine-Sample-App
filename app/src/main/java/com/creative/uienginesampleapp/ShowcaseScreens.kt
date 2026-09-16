package com.creative.uienginesampleapp

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun GesturesScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var tapText by remember { mutableStateOf("Interact with me") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .testTag("gesture_box")
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { tapText = "Clicked" },
                        onDoubleTap = { tapText = "Double Tapped" },
                        onLongPress = { tapText = "Long Pressed" }
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            Text(tapText, color = MaterialTheme.colorScheme.onPrimaryContainer)
        }

        // Drag and Drop
        var offset by remember { mutableStateOf(Offset.Zero) }
        Box(
            modifier = Modifier
                .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
                .size(80.dp)
                .background(Color.Red)
                .testTag("drag_box")
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offset += dragAmount
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text("Drag Me", color = Color.White, fontSize = 12.sp)
        }

        // Pinch and Rotate
        var scale by remember { mutableStateOf(1f) }
        var rotation by remember { mutableStateOf(0f) }
        Box(
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(scaleX = scale, scaleY = scale, rotationZ = rotation)
                .background(Color.Blue)
                .align(Alignment.CenterHorizontally)
                .testTag("transform_box")
                .pointerInput(Unit) {
                    detectTransformGestures { _, _, zoom, angle ->
                        scale *= zoom
                        rotation += angle
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text("Pinch/Rotate", color = Color.White)
        }
        
        Text("Multi-finger: Try swiping with 2+ fingers", modifier = Modifier.testTag("multi_finger_label"))
    }
}

@Composable
fun TextInputScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth().testTag("input_field"),
            label = { Text("Enter Text") }
        )
        Text("Current: $text", modifier = Modifier.testTag("text_output"))
        
        Button(onClick = { text = "" }, modifier = Modifier.testTag("clear_button")) {
            Text("Clear")
        }
        
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().testTag("focus_field"),
            label = { Text("Focus Target") }
        )
    }
}

@Composable
fun ScrollingScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize().testTag("lazy_list")) {
        itemsIndexed((0..100).toList()) { index, item ->
            ListItem(
                headlineContent = { Text("Item $index") },
                modifier = Modifier.testTag("item_$index").semantics { 
                    contentDescription = "Item $index"
                }
            )
        }
        item {
            Text("End of List", modifier = Modifier.padding(16.dp).testTag("list_footer"))
        }
    }
}

@Composable
fun SystemScreen() {
    val context = LocalContext.current
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        // Handle results
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("System Actions Tester")
        Button(
            onClick = { 
                val perms = mutableListOf(Manifest.permission.CAMERA)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    perms.add(Manifest.permission.POST_NOTIFICATIONS)
                }
                permissionLauncher.launch(perms.toTypedArray())
            },
            modifier = Modifier.testTag("permission_button")
        ) {
            Text("Request Permissions (Camera & Notify)")
        }
        
        Button(
            onClick = { showTestNotification(context) },
            modifier = Modifier.testTag("notification_button")
        ) {
            Text("Show Notification")
        }
        
        Text("Use the robot to test Home, Back, and Quick Settings.")
    }
}

private fun showTestNotification(context: Context) {
    val channelId = "test_channel"
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId, "Test Channel", NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(channel)
    }
    
    val notification = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.stat_notify_chat)
        .setContentTitle("My App Test")
        .setContentText("This is a test notification")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .build()
        
    notificationManager.notify(1, notification)
}

@Composable
fun AccessibilityScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).semantics { isTraversalGroup = true },
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Focus Order Test")
        Button(onClick = {}, modifier = Modifier.semantics { traversalIndex = 2f }.testTag("btn_last")) {
            Text("Should be 3rd")
        }
        Button(onClick = {}, modifier = Modifier.semantics { traversalIndex = 0f }.testTag("btn_first")) {
            Text("Should be 1st")
        }
        Button(onClick = {}, modifier = Modifier.semantics { traversalIndex = 1f }.testTag("btn_middle")) {
            Text("Should be 2nd")
        }
        
        Text("Label Test")
        IconButton(onClick = {}, modifier = Modifier.testTag("labeled_icon")) {
            Icon(Icons.Default.Add, contentDescription = "Add Action")
        }
        IconButton(onClick = {}, modifier = Modifier.testTag("unlabeled_icon")) {
            Icon(Icons.Default.Add, contentDescription = "Another Add Action")
        }
    }
}
