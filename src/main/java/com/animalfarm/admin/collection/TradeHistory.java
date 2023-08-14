package com.animalfarm.admin.collection;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Entity
@QueryEntity
@Getter @Setter @ToString
@RequiredArgsConstructor
@Document("tradeHistory")
public class TradeHistory {
    @Id
    private String id;
    private Trader acceptor;
    private Trader requester;
    private String tradeDate;
}

