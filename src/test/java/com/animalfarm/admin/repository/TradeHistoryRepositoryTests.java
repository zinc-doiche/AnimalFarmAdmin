package com.animalfarm.admin.repository;

import com.animalfarm.admin.collection.TradeHistory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TradeHistoryRepositoryTests {
    @Autowired
    private TradeHistoryRepository tradeHistoryRepository;

    @Test
    public void findTest() {
        String uuid = "005cd92d-cf8a-4267-bfc5-50d3f039d50f";
        log.info("=============================================");

        log.info("=============================================");
    }
}