package ca.gbc.comp3074.olpindo_dharwynivor.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MessageList()
            }
        }
    }

    data class Message(
        val name: String,
        val message: String
    )

    @Composable
    fun MessageList() {
        val messages = listOf(
            Message("Joe", "Hi!"),
            Message("Jim", "How are you?"),
            Message("Joe", "Test..1..2...3"),
            Message("Joe", "I hate coding!!!"),

            Message("Joe", "Hi!"),
            Message("Jim", "How are you?"),
            Message("Joe", "Test..1..2...3"),
            Message("Joe", "I hate coding!!!"),

            Message("Joe", "Hi!"),
            Message("Jim", "How are you?"),
            Message("Joe", "Test..1..2...3"),
            Message("Joe", "I hate coding!!!")
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFF7FF)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(messages) { message ->
                    MessageItem(message = message)
                }
            }
        }
    }

    @Composable
    fun MessageItem(message: Message) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Circle Avatar with Red Border
            Surface(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .border(BorderStroke(2.dp, Color.Red), CircleShape),
                color = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Android,
                    contentDescription = "Profile Picture",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = message.name,
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 4.dp, bottom = 4.dp)
                )

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFF2F2F7)
                ) {
                    Text(
                        text = message.message,
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}