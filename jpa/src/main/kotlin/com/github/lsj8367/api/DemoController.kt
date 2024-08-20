package com.github.lsj8367.api

import com.github.lsj8367.application.DemoService
import com.github.lsj8367.facade.DemoFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DemoController(
    private val demoFacade: DemoFacade,
) {

    @PostMapping("/save")
    fun save(): ResponseEntity<Boolean> {
        demoFacade.save()
        return ResponseEntity.ok(true)
    }
}