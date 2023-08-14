package com.animalfarm.admin.repository;

import com.animalfarm.admin.collection.TradeHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import static com.animalfarm.admin.collection.QTradeHistory.tradeHistory;

@Component
public class TradeHistoryQueryDSLImpl extends QuerydslRepositorySupport implements TradeHistoryQueryDSL {
    public TradeHistoryQueryDSLImpl(MongoOperations operations) {
        super(operations);
    }

    @Override
    public Page<TradeHistory> findAsPage(Pageable pageable) {
        return from(tradeHistory).fetchPage(pageable);
    }
}
