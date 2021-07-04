package com.thernat.ageofapocalypse.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun BigComicCard(
    imageUrl: String?,
    name: String,
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(192.dp)
    ) {
        Column {
            Image(
                painter = rememberCoilPainter(
                    request = imageUrl,
                ),
                contentDescription = "Content description",
            )
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .width(192.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}