package com.sargis.khlopuzyan.mobilebanking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.sargis.khlopuzyan.mobilebanking.ui.navigation.AppNavigation
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}