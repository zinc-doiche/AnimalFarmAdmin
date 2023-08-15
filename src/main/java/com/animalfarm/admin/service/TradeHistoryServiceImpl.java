package com.animalfarm.admin.service;

import com.animalfarm.admin.collection.TradeHistory;
import com.animalfarm.admin.domain.TradeHistoryDTO;
import com.animalfarm.admin.repository.TradeHistoryRepository;
import com.animalfarm.admin.util.Streams;
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
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class TradeHistoryServiceImpl implements TradeHistoryService {
    private static final String urlString = "https://sessionserver.mojang.com/session/minecraft/profile/";

    private final TradeHistoryRepository tradeHistoryRepository;

    @Override
    public Page<TradeHistory> getPage(Pageable pageable, String keyword) {
        return tradeHistoryRepository.findAllWithKeyword(pageable, keyword);
    }
}
