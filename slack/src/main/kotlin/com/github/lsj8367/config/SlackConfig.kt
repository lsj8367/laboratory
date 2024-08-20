package com.github.lsj8367.config

import com.github.lsj8367.infra.TestRepository
import com.slack.api.bolt.App
import com.slack.api.bolt.AppConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.StringBuilder

@Configuration
class SlackConfig {
    @Bean
    fun testApp(testRepository: TestRepository): App {
        val app = App(
            AppConfig.builder().signingSecret("")
                .singleTeamBotToken("")
                .build()
        )

        app.command("/test") { req, ctx ->
            val corpList = testRepository.findAll();
            val toList = corpList.stream().map { x -> x.name }
                .toList()
            val commandArgText = req.payload.text // 내가 보내는 전부 테스트
            val channelId = req.payload.channelId
            val channelName = req.payload.channelName

            val builder = StringBuilder()
            for (s  in toList) {
                builder.append(s).append("\n")
            }
//            val text = "You said ${toList} example ${commandArgText} at <#${channelId}|${channelName}>"
            ctx.ack(builder.toString())
        }

        return app
    }
}
