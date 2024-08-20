package com.github.lsj8367.facade

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoFacadeTest {

    @Autowired
    private lateinit var facade: DemoFacade

    @Test
    fun test() {
        facade.save()
        assertThrows<IllegalArgumentException> {
            facade.save()
        }
    }
}