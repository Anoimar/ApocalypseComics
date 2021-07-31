package com.thernat.ageofapocalypse.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ComicDetailsCard(
    imageUrl: String?,
    name: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .width(192.dp)
        ) {
            Image(
                painter = rememberCoilPainter(
                    request = imageUrl,
                    previewPlaceholder = R.drawable.notification_template_icon_bg,
                ),
                contentDescription = name,
            )
        }
        //Title
        Text(
            modifier = Modifier
                .wrapContentSize(),
            text = name,
            color = MaterialTheme.colors.onPrimary,
            style = TextStyle(
                fontSize = 19.sp
            )
        )
    }
}