package com.animalfarm.admin.repository

import com.animalfarm.admin.collection.TradeHistory
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TradeHistoryRepositoryTests() {
    @Autowired
    lateinit var log: Logger

    @Autowired
    lateinit var tradeHistoryRepository: TradeHistoryRepository

    @Test
    fun findTest() {
        val uuid = "005cd92d-cf8a-4267-bfc5-50d3f039d50f"
        log.info("=============================================")

        tradeHistoryRepository.findAllByAcceptor_UuidOrRequester_UuidOrderByIdDesc(uuid, uuid)
            .map(TradeHistory::toString)
            .forEach(log::info)
        log.info("=============================================")
    }
}