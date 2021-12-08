package com.example.kei.compose_playground.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.kei.compose_playground.repository.DemoContentsRepository
import com.example.kei.compose_playground.ui.components.CardCarousel
import com.example.kei.compose_playground.ui.components.MainHeader
import com.example.kei.compose_playground.ui.components.StickyMenu
import com.example.kei.compose_playground.ui.components.SubCarousel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    val localContext = LocalContext.current
    val fetchHeaderContents = DemoContentsRepository().fetchHeaderContents()

    LazyColumn {
        item {
            MainHeader(
                content = fetchHeaderContents[0],
                onClick = { showToast(localContext, "clickHeader") },
            )
        }
        stickyHeader {
            StickyMenu(
                onClickA = { showToast(localContext, "clickA") },
                onClickB = { showToast(localContext, "clickB") },
                onClickC = { showToast(localContext, "clickC") },
                onClickD = { showToast(localContext, "clickD") })
        }
        item {
            SubCarousel(contentsList = fetchHeaderContents) {
                showToast(localContext, "clickSubCarousel")
            }
        }
        item {
            CardCarousel(
                contentsList = fetchHeaderContents,
                onClickContents = { showToast(localContext, "clickCard") },
                onClickMore = { showToast(localContext, "clickMore") })
        }
    }
}
