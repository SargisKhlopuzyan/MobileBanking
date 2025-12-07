package com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.sargis.khlopuzyan.mobilebanking.auth.navigation.AuthRoute
import com.sargis.khlopuzyan.mobilebanking.uicommon.R

data class BtmNavItem(
    val nameRecId: Int,
    val icon: ImageVector,
    val route: String,
)

fun loginMainBtmNavEntries(): List<BtmNavItem> {
    return listOf(
        BtmNavItem(
            R.string.rates,
            Icons.Default.CurrencyExchange,
            AuthRoute.Rates.route
        ),
        BtmNavItem(
            R.string.map,
            Icons.Default.LocationOn,
            AuthRoute.Map.route
        ),
        BtmNavItem(
            R.string.news,
            Icons.Default.Newspaper,
            AuthRoute.News.route
        ),
        BtmNavItem(
            R.string.about,
            Icons.Outlined.Info,
            AuthRoute.About.route
        )
    )
}