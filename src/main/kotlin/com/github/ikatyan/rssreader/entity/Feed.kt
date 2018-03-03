package com.github.ikatyan.rssreader.entity

import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "feed")
data class Feed(
        @Id
        @GeneratedValue
        @Column(name = "feed_id")
        var feedId: Int = -1,

        @Column(name = "url", nullable = false)
        var url: String = "",

        @Column(name = "name", nullable = false)
        var name: String = "",

        @Column(name = "created_on", nullable = false)
        var createdOn: Timestamp? = null,

        @Column(name = "last_update", nullable = false)
        var lastUpdate: Timestamp? = null
) : Serializable