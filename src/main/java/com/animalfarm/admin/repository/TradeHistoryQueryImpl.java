package com.animalfarm.admin.repository;

import com.animalfarm.admin.collection.TradeHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@RequiredArgsConstructor
public class TradeHistoryQueryImpl implements TradeHistoryQuery {
    private final MongoTemplate mongoTemplate;

    @Override
    public Page<TradeHistory> findAllWithKeyword(Pageable pageable, String keyword) {
        final Query query =
                keyword != null
                        ? new Query(
                                new Criteria().orOperator(
                                        where("acceptor.name").regex(keyword, "i"),
                                        where("requester.name").regex(keyword, "i"),
                                        where("tradeDate").regex(keyword, "i")))
                        : new Query();
        final long count = mongoTemplate.count(query, TradeHistory.class);
        final List<TradeHistory> list = mongoTemplate.find(query.with(pageable).with(Sort.by(Sort.Direction.DESC, "_id")), TradeHistory.class);

        return new PageImpl<>(list, pageable, count);
    }
}
