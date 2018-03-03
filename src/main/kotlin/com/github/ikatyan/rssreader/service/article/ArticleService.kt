package com.github.ikatyan.rssreader.service.article

import com.github.ikatyan.rssreader.entity.Article

interface ArticleService {
    fun findOneByArticleId(id: Int): Article?
    fun findAllByFeedId(feedId: Int): List<Article>?
}