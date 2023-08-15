package com.animalfarm.admin.service;

import com.animalfarm.admin.collection.TradeHistory;
import com.animalfarm.admin.repository.TradeHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeHistoryServiceImpl implements TradeHistoryService {
    private static final String urlString = "https://sessionserver.mojang.com/session/minecraft/profile/";

    private final TradeHistoryRepository tradeHistoryRepository;

    @Override
    public Page<TradeHistory> getPage(Pageable pageable, String keyword) {
        return tradeHistoryRepository.findAllWithKeyword(pageable, keyword);
    }

    @Override
    public TradeHistory getTradeHistory(String id) {
        return tradeHistoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
