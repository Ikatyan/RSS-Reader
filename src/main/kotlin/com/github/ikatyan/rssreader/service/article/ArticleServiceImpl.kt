package com.github.ikatyan.rssreader.service.article

import com.github.ikatyan.rssreader.entity.Article
import com.github.ikatyan.rssreader.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleServiceImpl(private val articleRepository: ArticleRepository) : ArticleService {
    override fun findOneByArticleId(id: Int): Article? {
        return articleRepository.findOne(id)
    }
}