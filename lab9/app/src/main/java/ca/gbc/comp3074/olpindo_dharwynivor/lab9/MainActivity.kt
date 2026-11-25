package ca.gbc.comp3074.olpindo_dharwynivor.lab9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ca.gbc.comp3074.olpindo_dharwynivor.lab9.ui.theme.Lab9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab9Theme {
                ContactApp()
            }
        }
    }
}