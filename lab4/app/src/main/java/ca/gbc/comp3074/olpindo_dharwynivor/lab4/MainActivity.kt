package ca.gbc.comp3074.olpindo_dharwynivor.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.gbc.comp3074.olpindo_dharwynivor.lab4.data.AppDatabase
import ca.gbc.comp3074.olpindo_dharwynivor.lab4.ui.theme.CustomerApp
import ca.gbc.comp3074.olpindo_dharwynivor.lab4.ui.theme.CustomerViewModel
import ca.gbc.comp3074.olpindo_dharwynivor.lab4.ui.theme.CustomerViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = AppDatabase.getDatabase(applicationContext)
        setContent {
            MaterialTheme {
                val viewModel: CustomerViewModel = viewModel(
                    factory = CustomerViewModelFactory(
                        database.customerDao()
                    )
                )
                CustomerApp(viewModel)
            }
        }
    }
}