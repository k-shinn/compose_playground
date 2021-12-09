package com.example.kei.compose_playground.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.kei.compose_playground.R
import com.example.kei.compose_playground.model.DemoContent
import com.example.kei.compose_playground.ui.theme.Compose_playgroundTheme

@Composable
fun ListContents(
    content: DemoContent,
    selectedId: Int,
    onClick: () -> Unit,
) {
    val isSelected = selectedId == content.id
    val surfaceColor: Color by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.surface
    )

    ConstraintLayout(
        modifier = Modifier
            .clickable {
                onClick.invoke()
            }
            .background(color = surfaceColor)
            .fillMaxWidth()
    ) {
        val (image, title, description) = createRefs()
        createVerticalChain(
            title, description,
            chainStyle = ChainStyle.Packed
        )
        Image(
            painter = painterResource(id = R.drawable.dummy_thumbnail),
            contentDescription = null,
            modifier = Modifier
                .size(
                    width = 140.dp,
                    height = 100.dp
                )
                .constrainAs(image) {
                    start.linkTo(parent.start, margin = 8.dp)
                    top.linkTo(parent.top, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                }
        )
        Text(
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            text = content.title,
            modifier = Modifier
                .constrainAs(title) {
                    width = Dimension.fillToConstraints
                    top.linkTo(parent.top)
                    start.linkTo(image.end, margin = 4.dp)
                    bottom.linkTo(description.top)
                    end.linkTo(parent.end, margin = 8.dp)
                })
        Text(text = content.subTitle,
            maxLines = 2,
            modifier = Modifier.constrainAs(description) {
                width = Dimension.fillToConstraints
                top.linkTo(title.bottom)
                start.linkTo(image.end, margin = 4.dp)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, margin = 8.dp)
            })
    }
}

@Preview
@Composable
fun PreviewListContents() {
    val onclick = {}
    val content = DemoContent(
        id = 0,
        title = "header",
        subTitle = "subTitle",
        imageUrl = "https://placehold.jp/00ffff/ffffff/350x160.png"
    )
    Compose_playgroundTheme {
        ListContents(content, -1, onclick)
    }
}
