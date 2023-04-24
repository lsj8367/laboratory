package com.github.lsj8367.repository

import com.github.lsj8367.domain.Board
import org.springframework.data.repository.CrudRepository

interface BoardRepository: CrudRepository<Board, Long> {

}
