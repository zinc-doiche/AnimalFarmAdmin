package com.animalfarm.admin.service;

import com.animalfarm.admin.collection.TradeHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TradeHistoryService {
    Page<TradeHistory> getPage(Pageable pageable, String keyword);
}