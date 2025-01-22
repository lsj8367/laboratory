package com.github.lsj8367.quartz.service

import com.github.lsj8367.quartz.domain.Job
import com.github.lsj8367.quartz.service.request.JobSaveRequest
import org.springframework.stereotype.Service

@Service
class JobService {

    fun save(request: JobSaveRequest)  {
        val job = Job(null, request.cron!!, request.description!!)
    }
}