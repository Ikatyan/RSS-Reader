package com.github.ikatyan.rssreader.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "article")
data class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "article_id", nullable = false)
        var articleId: Int = -1,

        @Column(name = "feed_id", nullable = false)
        var feedId: Int = -1,

        @Column(name = "title", nullable = false)
        var title: String = "",

        @Column(name = "link", nullable = false)
        var link: String = "",

        @Column(name = "description", nullable = false)
        var description: String = "",

        @Column(name = "published_on", nullable = false)
        var publishedOn: Timestamp? = null,

        @JsonIgnore
        @Column(name = "created_on", nullable = false)
        var createdOn: Timestamp? = null
)
