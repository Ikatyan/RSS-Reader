package com.github.ikatyan.rssreader

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RssReaderApplication

fun main(args: Array<String>) {
    SpringApplication.run(RssReaderApplication::class.java, *args)
}
