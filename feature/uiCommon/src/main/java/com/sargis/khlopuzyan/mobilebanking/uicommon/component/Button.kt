package com.sargis.khlopuzyan.mobilebanking.uicommon.component

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.AppTheme
import com.sargis.khlopuzyan.mobilebanking.uicommon.theme.LocalAppShape

//val buttonGradientBrush = Brush.linearGradient(
//    colors = listOf(Color(0xFF132441), Color(0xFF0E9D3D)),
//    start = Offset(0f, 0f), // Top-left
//    end = Offset(500f, 500f), // Bottom-right
//)
//
//@Composable
//fun GradientButton(
//    modifier: Modifier = Modifier,
//    label: String,
//    onClick: () -> Unit,
//) {
//    Button(
//        modifier = modifier
//            .height(40.dp)
//            .fillMaxWidth()
//            .then(modifier),
//        onClick = onClick,
//        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
//        contentPadding = PaddingValues(),
//        shape = LocalAppShape.current.button
//    ) {
//        Box(
//            modifier = Modifier
//                .height(40.dp)
//                .fillMaxWidth()
//                .background(buttonGradientBrush)
//                .then(modifier),
//            contentAlignment = Alignment.Center,
//        ) {
//            Text(
//                modifier = Modifier.padding(horizontal = 8.dp),
//                text = label,
//                maxLines = 1,
//                color = Color.White,
//                style = MaterialTheme.typography.labelMedium
//            )
//        }
//    }
//}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .then(modifier),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = LocalAppShape.current.button
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = label,
            maxLines = 1,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth()
            .then(modifier),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = LocalAppShape.current.button,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, backgroundColor = 0xFFFFFF)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun PrimaryButtonPreview() {
    AppTheme {
        Column {
//            GradientButton(
//                label = "Gradient"
//            ) {
//
//            }

            PrimaryButton(
                label = "Primary"
            ) {

            }

            SecondaryButton(
                label = "Secondary"
            ) {

            }
        }
    }
}