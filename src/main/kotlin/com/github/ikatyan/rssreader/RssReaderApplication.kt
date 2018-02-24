package com.github.ikatyan.rssreader

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class RssReaderApplication

fun main(args: Array<String>) {
    SpringApplication.run(RssReaderApplication::class.java, *args)
}
