package com.github.lsj8367.quartz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuartzApplication

fun main(args: Array<String>) {
    runApplication<QuartzApplication>(*args)
}
