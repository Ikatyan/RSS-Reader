package com.github.ikatyan.rssreader.repository

import com.github.ikatyan.rssreader.entity.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Int>