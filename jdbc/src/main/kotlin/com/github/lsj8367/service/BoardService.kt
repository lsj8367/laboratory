package com.github.lsj8367.service

import com.github.lsj8367.domain.Board
import com.github.lsj8367.repository.BoardRepository
import com.github.lsj8367.service.request.RegisterBoardRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    fun save(request: RegisterBoardRequest) {
        val save =
            boardRepository.save(Board(null, request.title, request.content, LocalDateTime.now(), LocalDateTime.now()))

        val savedBoard = boardRepository.findById(save.id)
            .orElseThrow { RuntimeException("찾을 수 없음") }

        println(savedBoard.id)

    }
}
