package com.animalfarm.admin.service

import com.animalfarm.admin.domain.TradeHistoryDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TradeHistoryService {
    fun getPage(pageable: Pageable, keyword: String): Page<TradeHistoryDTO>
}