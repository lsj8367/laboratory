package com.github.lsj8367.application

import com.github.lsj8367.infra.DemoEntity
import com.github.lsj8367.infra.DemoRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DemoService(
    var demoRepository: DemoRepository
) {

    @Transactional
    fun save() {
        try {
            demoRepository.save(DemoEntity("name", "code"))
        } catch (e: DataIntegrityViolationException) {
            throw IllegalArgumentException(e.message)
        }
    }

    fun flush() {
        demoRepository.flush()
    }
}