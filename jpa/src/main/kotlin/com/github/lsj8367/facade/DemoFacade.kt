package com.github.lsj8367.facade

import com.github.lsj8367.application.DemoService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class DemoFacade(
    private val demoService: DemoService,
) {

    fun save() {
        try {
            demoService.save()
        } catch (e: Exception) {
            println(e.message)
        }

        demoService.flush()
    }
}
