package ca.gbc.comp3074.olpindo_dharwynivor.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat.enableEdgeToEdge
import ca.gbc.comp3074.olpindo_dharwynivor.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Lab2App()
            }
        }
    }
}

@Composable
fun Lab2App() {
    var count by remember { mutableStateOf(0) }
    var step by remember { mutableStateOf(1) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (logo, output, subtractButton, addButton, resetButton, stepButton) = createRefs()

        Text(
            text = "🔢",
            fontSize = 64.sp,
            modifier = Modifier.constrainAs(logo) {
                top.linkTo(parent.top, margin = 80.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "$count",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(output) {
                top.linkTo(logo.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(
            onClick = { count -= step },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
            modifier = Modifier
                .width(110.dp)
                .constrainAs(subtractButton) {
                    top.linkTo(output.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(addButton.start)
                }
        ) {
            Text("-", fontSize = 24.sp, color = Color.White)
        }

        Button(
            onClick = { count += step },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
            modifier = Modifier
                .width(110.dp)
                .constrainAs(addButton) {
                    top.linkTo(output.bottom, margin = 40.dp)
                    start.linkTo(subtractButton.end)
                    end.linkTo(parent.end)
                }
        ) {
            Text("+", fontSize = 24.sp, color = Color.White)
        }

        Button(
            onClick = {
                count = 0
                step = 1
            },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE91E63)),
            modifier = Modifier
                .width(110.dp)
                .constrainAs(resetButton) {
                    top.linkTo(subtractButton.bottom, margin = 20.dp)
                    start.linkTo(subtractButton.start)
                    end.linkTo(subtractButton.end)
                }
        ) {
            Text("Reset", fontSize = 18.sp, color = Color.White)
        }

        Button(
            onClick = {
                step = if (step == 1) 2 else 1
            },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (step == 2) Color(0xFF00C853) else Color(0xFF00E676)
            ),
            modifier = Modifier
                .width(110.dp)
                .constrainAs(stepButton) {
                    top.linkTo(addButton.bottom, margin = 20.dp)
                    start.linkTo(addButton.start)
                    end.linkTo(addButton.end)
                }
        ) {
            Text(
                text = if (step == 1) "Step" else "Step (2)",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}