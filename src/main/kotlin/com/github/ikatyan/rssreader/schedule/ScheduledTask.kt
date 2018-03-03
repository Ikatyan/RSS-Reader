package com.github.ikatyan.rssreader.schedule

import com.github.ikatyan.rssreader.repository.ArticleRepository
import com.github.ikatyan.rssreader.repository.FeedRepository
import com.github.ikatyan.rssreader.service.rss.CheckFeedService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTask(
        private val checkFeedService: CheckFeedService,
        private val articleRepository: ArticleRepository,
        private val feedRepository: FeedRepository) {

    @Scheduled(cron = "* */30 * * * *")
    fun findNewArticles() {
        println("Scheduled Task Start")
        val feedList = feedRepository.findAll() ?: return
        checkFeedService.fetchNewArticles(feedList)
                .forEach { articleRepository.save(it) }
        println("Scheduled Task End")
    }
}