package com.sargis.khlopuzyan.mobilebanking.auth.screen.login

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Fingerprint
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sargis.khlopuzyan.mobilebanking.uicommon.R
import com.sargis.khlopuzyan.mobilebanking.uicommon.component.InfoAlertDialog
import com.sargis.khlopuzyan.mobilebanking.uicommon.component.PrimaryButton
import com.sargis.khlopuzyan.mobilebanking.uicommon.component.PrimaryIconButton
import com.sargis.khlopuzyan.mobilebanking.uicommon.component.TransparentSecondaryIconButton
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.AppTheme
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.Typography

const val fakeImageUrl =
    "https://media.licdn.com/dms/image/v2/D4D03AQH9TxfX42DGrQ/profile-displayphoto-scale_200_200/B4DZmVgG_2JMAY-/0/1759149847674?e=1766620800&v=beta&t=ypCvAneL6kam2M1lekrWfQhkeCO1Ac4mmWbRG5i8k7A"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    uiState: LoginUIState, onEvent: (LoginUIEvent) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation = 3.dp),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onEvent(LoginUIEvent.NavigateUp)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = stringResource(R.string.login),
                        style = Typography.titleSmall
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null // This line removes the ripple effect
            ) { // Clear focus and hide keyboard when clicking outside the TextField
                focusManager.clearFocus()
                keyboardController?.hide()
            }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var username by rememberSaveable {
                    mutableStateOf(uiState.lastSignedInUsername)
                }

                LaunchedEffect(uiState.lastSignedInUsername) {
                    username = uiState.lastSignedInUsername
                }

                var password by rememberSaveable {
                    mutableStateOf("a1234")
                }

                var passwordVisible by rememberSaveable {
                    mutableStateOf(false)
                }

                Spacer(modifier = Modifier.height(24.dp))

                AsyncImage(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(
                            shape = RoundedCornerShape(35.dp)
                        ),
                    placeholder = rememberVectorPainter(Icons.Rounded.Person),
                    model = uiState.lastSignedInUserImageUrl,
                    contentDescription = "User profile picture",
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "${uiState.lastSignedInUserName} ${uiState.lastSignedInUserSurname}",
                    style = Typography.bodySmall
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth()
//                    .focusRequester(focusRequester)
                    ,
                    colors = TextFieldDefaults.colors(
                        focusedSupportingTextColor = Color.Gray,
                        unfocusedSupportingTextColor = Color.Gray,

                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,

                        focusedPlaceholderColor = Color.Gray,
                        unfocusedPlaceholderColor = Color.Gray,

                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,

                        focusedTextColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                    ),
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    textStyle = Typography.labelMedium,
                    label = {
                        Text("Password")
                    },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Please provide localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = image, description,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus() // Clear focus when "Done" is pressed
                        keyboardController?.hide() // Hide keyboard when "Done" is pressed
                    })
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        modifier = Modifier
                            .wrapContentWidth()
                            .clickable {
                                onEvent(LoginUIEvent.Register)
                            },
                        text = stringResource(R.string.forgot_your_password_question_mark),
                        style = Typography.labelSmall
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))


                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        label = stringResource(R.string.login),
                        onClick = {
                            onEvent(LoginUIEvent.Login(username, password))
                        }
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    PrimaryIconButton(
                        modifier = Modifier.weight(0.3f),
                        icon = rememberVectorPainter(Icons.Rounded.Fingerprint),
                        onClick = {
                            onEvent(LoginUIEvent.Login(username, password))
                        }
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                TransparentSecondaryIconButton(
                    modifier = Modifier.size(24.dp),
                    icon = rememberVectorPainter(Icons.Rounded.Settings),
                    onClick = {
                        onEvent(LoginUIEvent.Login(username, password))
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = stringResource(R.string.login_with_another_account),
                    style = Typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(32.dp))
            }

            if (uiState.error != null) {
                InfoAlertDialog(
                    onDismissRequest = {},
                    onConfirmation = {
                        onEvent(LoginUIEvent.HideDialog)
                    },
                    dialogTitle = uiState.error,
                    dialogText = null,
                    icon = null
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, backgroundColor = 0xFFFFFF)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppTheme {
        LoginScreen(LoginUIState()) {

        }
    }
}