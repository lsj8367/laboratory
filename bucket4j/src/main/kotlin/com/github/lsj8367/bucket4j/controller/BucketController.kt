package com.github.lsj8367.bucket4j.controller

import io.github.bucket4j.local.LocalBucket
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/test")
class BucketController(
    private val localBucket: LocalBucket
) {

    @GetMapping
    fun hello(): ResponseEntity<Boolean> {
        val tryConsume = localBucket.tryConsume(1)

        if (tryConsume) {
            return ResponseEntity.ok().build()
        }

        return ResponseEntity.badRequest().build()
    }
}