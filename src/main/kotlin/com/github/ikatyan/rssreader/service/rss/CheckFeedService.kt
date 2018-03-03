package com.github.ikatyan.rssreader.service.rss

import com.github.ikatyan.rssreader.entity.Article
import com.github.ikatyan.rssreader.entity.Feed

interface CheckFeedService {
    fun fetchNewArticles(feedList: List<Feed>): List<Article>
}