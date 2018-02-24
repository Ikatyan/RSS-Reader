package com.github.ikatyan.rssreader.controller

import com.github.ikatyan.rssreader.service.article.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HelloController(private val articleService: ArticleService) {

    @GetMapping("/")
    fun index(): String {

        val article = articleService.findOneByArticleId(1) ?: return "Not Found"
        return article.title
    }
}