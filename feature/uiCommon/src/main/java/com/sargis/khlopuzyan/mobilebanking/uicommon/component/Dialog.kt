package com.sargis.khlopuzyan.mobilebanking.uicommon.component

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sargis.khlopuzyan.mobilebanking.uicommon.R
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.AppTheme
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.Typography

@Composable
fun InfoAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    icon: ImageVector? = null,
    dialogTitle: String,
    dialogText: String? = null,
    confirmButtonText: String = stringResource(R.string.ok),
    dismissButtonText: String? = null,
) {
    AlertDialog(
        iconContentColor = MaterialTheme.colorScheme.onSurface,
        containerColor = MaterialTheme.colorScheme.surface,
        icon = icon?.let {
            @Composable {
                Icon(icon, contentDescription = "Example Icon")
            }
        },
        title = {
            Text(
                text = dialogTitle,
                style = Typography.bodySmall
            )
        },
        text = dialogText?.let {
            @Composable {
                Text(text = dialogText)
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(confirmButtonText)
            }
        },
        dismissButton = dismissButtonText?.let {
            @Composable {
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text(dismissButtonText)
                }
            }
        },
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, backgroundColor = 0xFFFFFF)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AlertDialogPreview() {
    AppTheme {
        InfoAlertDialog(
            onDismissRequest = {},
            onConfirmation = {},
            dialogTitle = "Title",
            dialogText = "Content",
            icon = Icons.Default.Info,
            confirmButtonText = "OK"
        )
    }
}