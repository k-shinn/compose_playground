package com.example.kei.compose_playground.repository

import android.graphics.Color
import com.example.kei.compose_playground.model.DemoContent
import kotlin.random.Random

class DemoContentsRepository {
    val color = Random(System.currentTimeMillis())
    fun fetchHeaderContents(): List<DemoContent> {
        val listOf = mutableListOf<DemoContent>()
        for (i in 0..9) {

            listOf.add(
                DemoContent(
                    title = "header$i",
                    subTitle = "subTitle$i",
                    imageUrl = "https://placehold.jp/${randomColor().toString(16)}/ffffff/350x160.png?text=title$i"
                )
            )
        }
        return listOf
    }
}

fun randomColor(): Int {
    // TODO: 毎回同じ値になる？Systemの生成の問題？
    return when (Random(System.currentTimeMillis()).nextInt() % 5) {
        1 -> Color.BLUE
        2 -> Color.CYAN
        3 -> Color.DKGRAY
        4 -> Color.GREEN
        else -> Color.RED
    }
}