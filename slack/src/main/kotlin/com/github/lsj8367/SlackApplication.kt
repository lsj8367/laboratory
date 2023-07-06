package com.github.lsj8367

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan(basePackages = ["com.github.lsj8367.component"])
class SlackApplication

fun main(args: Array<String>) {
    runApplication<SlackApplication>(*args)
}
