package com.animalfarm.admin.repository

import com.animalfarm.admin.collection.TradeHistory
import org.springframework.data.repository.CrudRepository

interface TradeHistoryRepository: CrudRepository<TradeHistory, String> {
    fun findAllByAcceptor_UuidOrRequester_Uuid(acceptorUuid: String, requesterUuid: String): List<TradeHistory>
}