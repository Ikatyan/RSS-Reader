package com.github.ikatyan.rssreader.schedule

import com.github.ikatyan.rssreader.repository.ArticleRepository
import com.github.ikatyan.rssreader.repository.FeedRepository
import com.github.ikatyan.rssreader.service.rss.CheckFeedService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ScheduledTask(
        private val checkFeedService: CheckFeedService,
        private val articleRepository: ArticleRepository,
        private val feedRepository: FeedRepository
) {
    private val logger = LoggerFactory.getLogger(ScheduledTask::class.java)

    @Scheduled(fixedDelay = 30 * 60 * 1000)
    @Transactional
    fun findNewArticles() {
        logger.info("Scheduled Task Start")
        val feedList = feedRepository.findAll() ?: return
        checkFeedService.fetchNewArticles(feedList)
                .forEach { articleRepository.save(it) }
        logger.info("Scheduled Task End")
    }
}