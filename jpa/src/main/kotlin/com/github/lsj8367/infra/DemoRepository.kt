package com.github.lsj8367.infra

import org.springframework.data.jpa.repository.JpaRepository

interface DemoRepository: JpaRepository<DemoEntity, Long> {
}