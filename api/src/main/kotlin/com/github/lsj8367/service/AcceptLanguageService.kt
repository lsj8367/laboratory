package com.github.lsj8367.service

import com.github.lsj8367.infra.LocalRequestFeign
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AcceptLanguageService(
        val localRequestFeign: LocalRequestFeign
) {

    fun test(date: LocalDate): ResponseEntity<Boolean> {
        localRequestFeign.accept(date)
        return ResponseEntity.ok(true)
    }

}