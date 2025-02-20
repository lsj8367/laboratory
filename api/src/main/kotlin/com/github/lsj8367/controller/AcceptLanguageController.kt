package com.github.lsj8367.controller

import com.github.lsj8367.service.AcceptLanguageService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class AcceptLanguageController(
        val acceptLanguageService: AcceptLanguageService
) {

    @GetMapping("/api/v1/accept")
    fun hello(@RequestParam date: LocalDate) : ResponseEntity<Boolean> {
        println(date.toString())
        return ResponseEntity.ok(true)
    }

    @GetMapping("/api/v1/test")
    fun hello2(@RequestParam date: LocalDate) : ResponseEntity<Boolean> {
        acceptLanguageService.test(date)
        return ResponseEntity.ok(true)
    }
}