package com.example.kei.compose_playground.repository

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
                    imageUrl = "https://placehold.jp/00ffff/ffffff/350x160?text=title$i.png"
                )
            )
        }
        return listOf
    }
}
