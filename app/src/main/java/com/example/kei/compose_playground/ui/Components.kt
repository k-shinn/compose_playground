package com.example.kei.compose_playground.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.example.kei.compose_playground.R
import com.example.kei.compose_playground.model.DemoContent
import com.example.kei.compose_playground.ui.theme.Compose_playgroundTheme

@Composable
fun MainHeader(
    contentsList: List<DemoContent>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(contentsList) { item ->
            HeaderContents(content = item)
        }
    }
}

@Composable
fun HeaderContents(
    content: DemoContent,
    modifier: Modifier = Modifier
) {
    Surface(color = MaterialTheme.colors.primary) {
        Image(
            painter = rememberImagePainter(
                data = content.imageUrl,
                builder = { placeholder(R.drawable.header_placeholder) }
            ),
            contentDescription = null,
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview
@Composable
fun PreviewHeaderContent() {
    val content = DemoContent(
        title = "header",
        subTitle = "subTitle",
        imageUrl = "https://placehold.jp/00ffff/ffffff/350x160.png"
    )
    Compose_playgroundTheme {
        HeaderContents(content = content)
    }
}
