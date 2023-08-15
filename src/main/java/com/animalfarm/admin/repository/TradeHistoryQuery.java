package com.animalfarm.admin.repository;

import com.animalfarm.admin.collection.TradeHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TradeHistoryQuery {
    Page<TradeHistory> findAllWithKeyword(Pageable pageable, String keyword);
}
