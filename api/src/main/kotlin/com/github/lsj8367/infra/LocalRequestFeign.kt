package com.github.lsj8367.infra

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@FeignClient(name = "local-request", url = "http://localhost:8080")
interface LocalRequestFeign {

    @GetMapping("/api/v1/accept")
    fun accept(@RequestParam date: LocalDate): String
}