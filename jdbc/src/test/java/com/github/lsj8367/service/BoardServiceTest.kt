package com.github.lsj8367.service

import com.github.lsj8367.service.request.RegisterBoardRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BoardServiceTest(
    @Autowired private val boardService: BoardService
) {
    @Test
    fun test() {
        boardService.save(RegisterBoardRequest("title", "content"))
    }

}
