package com.github.lsj8367.infra

import com.github.lsj8367.domain.Board
import org.springframework.data.repository.CrudRepository

interface BoardRepository: CrudRepository<Board, Long> {

}
