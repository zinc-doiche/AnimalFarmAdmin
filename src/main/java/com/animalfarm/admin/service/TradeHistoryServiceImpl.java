package com.animalfarm.admin.service;

import com.animalfarm.admin.collection.TradeHistory;
import com.animalfarm.admin.domain.TradeHistoryDTO;
import com.animalfarm.admin.repository.TradeHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class TradeHistoryServiceImpl implements TradeHistoryService {
    private static final String urlString = "https://sessionserver.mojang.com/session/minecraft/profile/";

    private final TradeHistoryRepository tradeHistoryRepository;

    @Override
    public Page<TradeHistoryDTO> getPage(Pageable pageable, String keyword) {
        return tradeHistoryRepository.findAsPage(pageable).map(TradeHistoryServiceImpl::toDTO);
    }

    private static TradeHistoryDTO toDTO(TradeHistory tradeHistory) {
        return TradeHistoryDTO.builder()
                .acceptorName(tradeHistory.getAcceptor().getUuid())
                .build();
    }
}
