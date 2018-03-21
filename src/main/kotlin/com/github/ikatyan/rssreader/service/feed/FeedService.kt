package com.github.ikatyan.rssreader.service.feed

import com.github.ikatyan.rssreader.entity.Feed

interface FeedService {
    fun findAll(): List<Feed>?
    fun save(feed: Feed): Feed?
}