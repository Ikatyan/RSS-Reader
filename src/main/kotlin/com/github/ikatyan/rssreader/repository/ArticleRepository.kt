package com.github.ikatyan.rssreader.repository

import com.github.ikatyan.rssreader.entity.Article
import com.github.ikatyan.rssreader.entity.Feed
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Int> {
    fun existsByLink(link: String): Boolean
}

interface FeedRepository : JpaRepository<Feed, Int>