package com.thernat.ageofapocalypse.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ComicDetailsCard(
    imageUrl: String?,
    name: String
) {
    Column(
        modifier = Modifier.wrapContentSize(),
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
                ),
                contentDescription = name,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComicDetailsCardPreview() {
    ComicDetailsCard(
        imageUrl = "url",
        name = "X of Swords HANDBOOK",
    )
}