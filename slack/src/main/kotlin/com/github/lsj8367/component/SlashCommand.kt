package com.github.lsj8367.component

import com.slack.api.bolt.App
import com.slack.api.bolt.servlet.SlackAppServlet
import org.springframework.beans.factory.annotation.Qualifier
import javax.servlet.annotation.WebServlet

@WebServlet("/slack/events/test")
class SlashCommand(@Qualifier("testApp") app: App?) : SlackAppServlet(app)
