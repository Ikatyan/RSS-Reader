package com.github.ikatyan.rssreader.controller

import com.github.ikatyan.rssreader.entity.Article
import com.github.ikatyan.rssreader.entity.Feed
import com.github.ikatyan.rssreader.service.article.ArticleService
import com.github.ikatyan.rssreader.service.feed.FeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class HelloController(
        private val articleService: ArticleService,
        private val feedService: FeedService) {

    @GetMapping("/")
    fun index(): String {
        return "Hello World!"
    }

    @GetMapping("/article/{feedId}")
    fun findArticlesByFeedId(@PathVariable(value = "feedId") feedId: Int): List<Article>? {
        return articleService.findAllByFeedId(feedId)
    }

    @GetMapping("/feed")
    fun findAllFeeds(): List<Feed>? {
        return feedService.findAll()
    }

    @PostMapping("/feed")
    @ResponseStatus(HttpStatus.CREATED)
    fun createFeed(feed: Feed) {
        feedService.save(feed)
    }

}