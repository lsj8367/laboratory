package com.github.lsj8367.bucket4j.config

import io.github.bucket4j.Bandwidth
import io.github.bucket4j.Bucket
import io.github.bucket4j.local.LocalBucket
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class BucketConfiguration {

    @Bean
    fun bucket(): LocalBucket {
        val bandwidth = Bandwidth.builder()
            .capacity(1L)
            .refillIntervally(1L, Duration.ofMinutes(10L))
            .build()

        return Bucket.builder()
            .addLimit(bandwidth)
            .build()
    }
}