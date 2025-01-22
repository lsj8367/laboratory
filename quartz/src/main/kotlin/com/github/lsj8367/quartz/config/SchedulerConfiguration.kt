package com.github.lsj8367.quartz.config

import com.github.lsj8367.quartz.scheduler.SampleScheduler
import org.quartz.*
import org.springframework.boot.autoconfigure.quartz.QuartzProperties
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.quartz.SchedulerFactoryBean
import org.springframework.scheduling.quartz.SpringBeanJobFactory
import java.util.*


@Configuration
class SchedulerConfiguration {

    @Bean
    fun scheduler(scheduler: Scheduler): Scheduler {
        scheduler.start()

//        scheduler.listenerManager.addJobListener(null)
        if (!scheduler.checkExists(JobKey.jobKey("sampleJob", "sampleJob"))) {
            val job = JobBuilder.newJob(SampleScheduler::class.java)
                    .withIdentity("sampleJob", "sampleJob")
                    .build()

            val trigger: Trigger = TriggerBuilder.newTrigger()
                    .withIdentity("sampleTrigger", "sampleTrigger")
                    .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                    .build()
            scheduler.scheduleJob(job, trigger)
        }

        return scheduler
    }
}