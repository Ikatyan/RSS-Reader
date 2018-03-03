package com.github.ikatyan.rssreader.service.rss

import com.github.ikatyan.rssreader.entity.Article
import com.github.ikatyan.rssreader.entity.Feed
import com.github.ikatyan.rssreader.repository.ArticleRepository
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.URL
import java.sql.Timestamp
import java.time.Instant

@Service
class CheckFeedServiceImpl(
        @Autowired private val articleRepository: ArticleRepository) : CheckFeedService {
    override fun fetchNewArticles(feedList: List<Feed>): List<Article> {
        val syndFeedInput = SyndFeedInput()
        val timestamp = Timestamp(Instant.now().toEpochMilli())

        //登録しているサイトからRSSフィードを取得する
        return feedList.flatMap { feed ->
            val syndFeed = syndFeedInput.build(XmlReader(URL(feed.url)))
            val list = syndFeed.entries
                    .map {
                        Article(
                                feedId = feed.feedId,
                                title = it.title,
                                link = it.link,
                                description = it.description.value,
                                publishedOn = Timestamp(it.publishedDate.time),
                                createdOn = timestamp
                        )
                    }
                    .takeWhile { !articleRepository.existsByLink(it.link) }
            list
        }
    }
}