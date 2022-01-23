package com.example.kei.compose_playground.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.kei.compose_playground.R
import com.example.kei.compose_playground.model.DemoContent
import com.example.kei.compose_playground.ui.theme.Compose_playgroundTheme

@Composable
fun MainHeader(
    content: DemoContent,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dummy_header),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(text = content.title)
    }
}

@Composable
fun StickyMenu(
    onClickA: () -> Unit,
    onClickB: () -> Unit,
    onClickC: () -> Unit,
    onClickD: () -> Unit,
) {
    Row {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .weight(weight = 1f)
        ) {
            StickyMenuContents(
                id = android.R.drawable.ic_dialog_info,
                text = stringResource(R.string.sticky_menu_a),
                onClick = onClickA
            )
        }
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .weight(weight = 1f)
        ) {
            StickyMenuContentsWithBalloon(
                id = android.R.drawable.ic_dialog_alert,
                text = stringResource(R.string.sticky_menu_b),
                onClick = onClickB
            )
        }
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .weight(weight = 1f)
        ) {
            StickyMenuContents(
                id = android.R.drawable.ic_menu_add,
                text = stringResource(R.string.sticky_menu_c),
                onClick = onClickC
            )
        }
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .weight(weight = 1f)
        ) {
            StickyMenuContents(
                id = android.R.drawable.ic_menu_help,
                text = stringResource(R.string.sticky_menu_d),
                onClick = onClickD
            )
        }
    }
}

@Composable
fun StickyMenuContents(
    @DrawableRes id: Int,
    text: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = Color.DarkGray)
            .padding(bottom = 4.dp, top = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = id),
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
        Text(
            text = text,
            fontSize = 12.sp
        )
    }
}

@Composable
fun StickyMenuContentsWithBalloon(
    @DrawableRes id: Int,
    text: String,
    onClick: () -> Unit
) {
    Box {
        StickyMenuContents(id = id, text = text, onClick = onClick)
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(0.dp, -(30.dp)) // TODO: 適切なOffset値(Balloon自体のサイズ)を取得設定する方法が分からない
        ) {
            Balloon(message = "test")
        }
    }
}

@Composable
fun Balloon(
    message: String
) {
    val tailShape = GenericShape { size, _ ->
        lineTo(size.width, 0f)
        lineTo(size.width / 2, size.height)
    }

    Column {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.Red)
        ) {
            Text(
                text = message,
                color = Color.White,
                modifier = Modifier.padding(
                    horizontal = 8.dp,
                    vertical = 2.dp
                )
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(10.dp)
                .clip(tailShape)
                .background(color = Color.Red)
        )
    }
}

@Preview
@Composable
fun PreviewHeaderContent() {
    val onclick = {}
    val content = DemoContent(
        id = 0,
        title = "header",
        subTitle = "subTitle",
        imageUrl = "https://placehold.jp/00ffff/ffffff/350x160.png"
    )
    Compose_playgroundTheme {
        MainHeader(
            content = content,
            onClick = onclick
        )
    }
}

@Preview
@Composable
fun PreviewHeaderStickyMenu() {
    val onclick = {}
    Compose_playgroundTheme {
        StickyMenu(onclick, onclick, onclick, onclick)
    }
}


@Preview
@Composable
fun PreviewBalloon() {
    Compose_playgroundTheme {
        Balloon(message = "バルーン表示テスト")
    }
}