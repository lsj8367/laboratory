package com.github.lsj8367.controller

import com.github.lsj8367.service.TestService
import com.github.lsj8367.service.response.CorporationResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    val testService: TestService
) {

    @GetMapping("/hi")
    fun getCorporations(): ResponseEntity<List<CorporationResponse>> {
        return ResponseEntity.ok(testService.getCorporations())
    }
}
