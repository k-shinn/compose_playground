package com.example.kei.compose_playground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kei.compose_playground.R
import com.example.kei.compose_playground.model.DemoContent
import com.example.kei.compose_playground.ui.theme.Compose_playgroundTheme

@Composable
fun SubCarousel(
    contentsList: List<DemoContent>,
    onClickContents: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
    ) {
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(contentsList) { content ->
                SubCarouselContents(
                    content = content,
                    onClick = onClickContents
                )
            }
        }
    }
}

@Composable
fun SubCarouselContents(
    content: DemoContent,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick),
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.dummy_sub_header),
                contentDescription = null,
                modifier = Modifier.size(
                    width = 200.dp,
                    height = 100.dp
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewSubCarouselContents() {
    val onclick = {}
    val content = DemoContent(
        title = "header",
        subTitle = "subTitle",
        imageUrl = "https://placehold.jp/00ffff/ffffff/350x160.png"
    )
    Compose_playgroundTheme {
        SubCarouselContents(content, onclick)
    }
}

@Preview
@Composable
fun PreviewSubCarousel() {
    val onclick = {}
    val content = DemoContent(
        title = "header",
        subTitle = "subTitle",
        imageUrl = "https://placehold.jp/00ffff/ffffff/350x160.png"
    )
    Compose_playgroundTheme {
        SubCarousel(listOf(content, content, content), onclick)
    }
}