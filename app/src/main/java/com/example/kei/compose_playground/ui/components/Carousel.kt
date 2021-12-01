package com.example.kei.compose_playground.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kei.compose_playground.R
import com.example.kei.compose_playground.model.DemoContent
import com.example.kei.compose_playground.ui.theme.Compose_playgroundTheme

@Composable
fun CardCarousel(
    contentsList: List<DemoContent>,
    onClickContents: () -> Unit,
    onClickMore: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxWidth()
    ) {
        Row {
            Text(
                text = "タイトル",
                modifier = Modifier.weight(weight = 1f, fill = true)
            )
            Text(
                text = "もっと見る",
                modifier = Modifier
                    .clickable(onClick = onClickMore)
                    .padding(horizontal = 8.dp)
            )
        }
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(contentsList) { content ->
                ThumbnailCard(
                    content = content,
                    onClick = onClickContents
                )
            }
        }
    }
}

@Composable
fun ThumbnailCard(
    content: DemoContent,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick),
        backgroundColor = Color.LightGray
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.dummy_thumbnail),
                contentDescription = null,
                modifier = Modifier.size(
                    width = 140.dp,
                    height = 100.dp
                )
            )
            Text(text = content.title)
        }
    }
}

@Preview
@Composable
fun PreviewThumbnailCard() {
    val onclick = {}
    val content = DemoContent(
        title = "header",
        subTitle = "subTitle",
        imageUrl = "https://placehold.jp/00ffff/ffffff/350x160.png"
    )
    Compose_playgroundTheme {
        ThumbnailCard(content, onclick)
    }
}

@Preview
@Composable
fun PreviewCardCarousel() {
    val onclick = {}
    val content = DemoContent(
        title = "header",
        subTitle = "subTitle",
        imageUrl = "https://placehold.jp/00ffff/ffffff/350x160.png"
    )
    Compose_playgroundTheme {
        CardCarousel(listOf(content, content, content), onclick, onclick)
    }
}
