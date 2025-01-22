package com.github.lsj8367.quartz.scheduler

import org.quartz.Job
import org.quartz.JobExecutionContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SampleScheduler: Job{
    private val log = LoggerFactory.getLogger(this.javaClass)!!

    override fun execute(context: JobExecutionContext?) {
        log.info("배치가 수행된다!")
    }
}