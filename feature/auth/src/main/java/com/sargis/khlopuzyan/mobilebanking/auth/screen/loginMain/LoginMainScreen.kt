package com.sargis.khlopuzyan.mobilebanking.auth.screen.loginMain

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.mobilebanking.uicommon.R
import com.sargis.khlopuzyan.mobilebanking.uicommon.component.PrimaryButton
import com.sargis.khlopuzyan.mobilebanking.uicommon.component.SecondaryButton
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.AppTheme
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.Typography

@Composable
fun LoginMainScreen(
    uiState: LoginMainUIState, onEvent: (LoginMainUIEvent) -> Unit,
    onItemClick: (String) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.background,
                windowInsets = NavigationBarDefaults.windowInsets
            ) {
                loginMainBtmNavEntries().forEach { item ->
                    NavigationBarItem(
                        selected = false,
                        icon = {
                            NavBarItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .aspectRatio(1f),
                                onItemClick = onItemClick,
                                navBarItem = item
                            )
                        },
                        onClick = {
                            onItemClick(item.route)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            unselectedIconColor = MaterialTheme.colorScheme.onTertiaryFixedVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onBackground
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    modifier = Modifier
                        .height(0.dp)
                        .fillMaxWidth()
                        .weight(1f),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.ic_amio_bank_main),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(40.dp))

                PrimaryButton(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = stringResource(R.string.login)
                ) {
                    onEvent(LoginMainUIEvent.Login)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    SecondaryButton(
                        modifier = Modifier.weight(0.5f),
                        label = stringResource(R.string.online_registration)
                    ) {
                        onEvent(LoginMainUIEvent.OnlineRegistration)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    SecondaryButton(
                        modifier = Modifier.weight(0.5f),
                        label = stringResource(R.string.become_a_customer)
                    ) {
                        onEvent(LoginMainUIEvent.BecomeACustomer)
                    }
                }

                Spacer(modifier = Modifier.height(48.dp))
            }

            IconButton(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable(onClick = {
                        onEvent.invoke(LoginMainUIEvent.ChooseLocale)
                    })
                    .padding(8.dp)
                    .align(Alignment.TopEnd),
                onClick = {

                }
            ) {
                Text(
                    text = "ENG",
                    style = Typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun NavBarItem(
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    navBarItem: BtmNavItem,
) {
    Column(
        modifier.clickable {
            onItemClick(navBarItem.route)
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = navBarItem.icon,
            tint = MaterialTheme.colorScheme.onTertiaryFixedVariant,
            contentDescription = stringResource(navBarItem.nameRecId)
        )

        Text(
            text = stringResource(navBarItem.nameRecId),
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.labelSmall,
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, backgroundColor = 0xFFFFFF)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun LoginMainScreenPreview() {
    AppTheme {
        LoginMainScreen(uiState = LoginMainUIState(), onEvent = {}) {

        }
    }
}