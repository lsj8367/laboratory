package com.github.lsj8367.repository

import com.github.lsj8367.entity.Corporation
import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository: JpaRepository<Corporation, Long> {
}
