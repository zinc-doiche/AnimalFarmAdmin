package com.animalfarm.admin.service;

import com.animalfarm.admin.collection.TradeHistory;
import com.animalfarm.admin.domain.TradeHistoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URL;

interface TradeHistoryService {
    Page<TradeHistoryDTO> getPage(Pageable pageable, String keyword);
}