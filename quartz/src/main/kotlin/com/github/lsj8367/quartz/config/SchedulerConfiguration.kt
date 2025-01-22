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
    fun scheduler(applicationContext: ApplicationContext?, quartzProperties: QuartzProperties): Scheduler {
        val schedulerFactory = schedulerFactoryBean(applicationContext, quartzProperties)
        val scheduler = schedulerFactory.getScheduler()

        scheduler.start()

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

    @Bean
    fun schedulerFactoryBean(applicationContext: ApplicationContext?, quartzProperties: QuartzProperties): SchedulerFactoryBean {
        val schedulerFactoryBean = SchedulerFactoryBean()
        val jobFactory = SpringBeanJobFactory()
        val properties = Properties()
        properties.putAll(quartzProperties.getProperties())
        schedulerFactoryBean.setQuartzProperties(properties)
        schedulerFactoryBean.setJobFactory(jobFactory) // job factory 등록
        schedulerFactoryBean.setApplicationContext(applicationContext!!) // context 등록
        schedulerFactoryBean.setOverwriteExistingJobs(false) // job 중복 허용 (덮어쓰기)
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true) // shutdown wait 속성
        return schedulerFactoryBean
    }
}