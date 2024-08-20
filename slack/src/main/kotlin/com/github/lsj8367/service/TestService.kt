package com.github.lsj8367.service

import com.github.lsj8367.infra.TestRepository
import com.github.lsj8367.service.response.CorporationResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TestService(
    val testRepository: TestRepository
) {

    fun getCorporations(): List<CorporationResponse> {
        val corpList = testRepository.findAll();
        return corpList.stream()
            .map { x -> CorporationResponse(x.id!!, x.name, x.address) }
            .toList()
    }
}
