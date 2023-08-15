package com.animalfarm.admin.repository;

import com.animalfarm.admin.collection.TradeHistory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class TradeHistoryRepositoryTests {
    @Autowired
    private TradeHistoryRepository tradeHistoryRepository;

    @Test
    public void findAllTest() {
        Page<TradeHistory> page = tradeHistoryRepository.findAll(Pageable.ofSize(10));
        assertThat(page.getTotalElements()).isEqualTo(5);
        page.get().map(TradeHistory::toString).forEach(log::info);
    }

    @Test
    public void findAllByKeywordTest() {
        Page<TradeHistory> page = tradeHistoryRepository.findAllWithKeyword(Pageable.ofSize(10), null);
        assertThat(page.getTotalElements()).isEqualTo(5);
        page.get().map(TradeHistory::toString).forEach(log::info);
    }

    @Test
    public void regexTest() {
        assertTrue("keyword".matches(".*keyword.*"));
        assertTrue("123keyword123".matches(".*keyword.*"));
        assertTrue("123  keyword   123".matches(".*keyword.*"));
        assertTrue("   keyword   123".matches(".*keyword.*"));
    }
}