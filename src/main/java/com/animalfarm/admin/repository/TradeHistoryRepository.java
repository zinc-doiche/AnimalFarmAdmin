package com.animalfarm.admin.repository;

import com.animalfarm.admin.collection.TradeHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TradeHistoryRepository extends MongoRepository<TradeHistory, String>, QuerydslPredicateExecutor<TradeHistory>, TradeHistoryQueryDSL {

}