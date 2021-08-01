package com.thernat.ageofapocalypse.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thernat.ageofapocalypse.ui.theme.TextGrey
import com.thernat.ageofapocalypse.ui.theme.TextPurple

@Composable
fun ComicDetailsPerson(
    position: String,
    personName: String?,
) {
    Column {
        Text(
            text = "$position:".replaceFirstChar {
                it.uppercaseChar()
            },
            color = TextPurple,
            modifier = Modifier.padding(end = 2.dp)
        )
        Text(
            text = personName.orEmpty(),
            color = TextGrey
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComicDetailsPersonPreview() {
    ComicDetailsPerson(
        position = "Writer",
        personName = "John Johnson",
    )
}