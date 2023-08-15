package com.animalfarm.admin.repository;

import com.animalfarm.admin.collection.TradeHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TradeHistoryRepository extends MongoRepository<TradeHistory, String>, TradeHistoryQuery {

}