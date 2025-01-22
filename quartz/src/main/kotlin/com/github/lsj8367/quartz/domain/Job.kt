package com.github.lsj8367.quartz.domain

data class Job(
        val id: Long?,
        val cron: String,
        val description: String
)