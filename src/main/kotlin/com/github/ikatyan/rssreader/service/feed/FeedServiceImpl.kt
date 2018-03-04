package com.github.ikatyan.rssreader.service.feed

import com.github.ikatyan.rssreader.entity.Feed
import com.github.ikatyan.rssreader.repository.FeedRepository
import org.springframework.stereotype.Service

@Service
class FeedServiceImpl(private val feedRepository: FeedRepository) : FeedService {
    override fun findAll(): List<Feed>? {
        return feedRepository.findAll()
    }
}