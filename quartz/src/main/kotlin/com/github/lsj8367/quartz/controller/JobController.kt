package com.github.lsj8367.quartz.controller

import com.github.lsj8367.quartz.service.JobService
import com.github.lsj8367.quartz.service.request.JobSaveRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class JobController(
        private val jobService: JobService
) {

    @PostMapping("/api/v1/job")
    fun saveJob(@RequestBody @Valid request: JobSaveRequest): ResponseEntity<Boolean> {
        jobService.save(request)
        return ResponseEntity.ok(true)
    }
}