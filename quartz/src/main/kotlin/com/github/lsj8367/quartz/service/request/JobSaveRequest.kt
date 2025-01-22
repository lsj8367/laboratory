package com.github.lsj8367.quartz.service.request

import jakarta.validation.constraints.NotEmpty

class JobSaveRequest {

    @NotEmpty
    val cron: String? = null

    @NotEmpty
    val description: String? = null

}