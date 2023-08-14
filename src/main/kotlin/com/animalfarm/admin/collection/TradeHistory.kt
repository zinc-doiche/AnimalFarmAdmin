package com.animalfarm.admin.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document

@Document("tradeHistory")
data class TradeHistory(
    @Id
    var id: String,
    var acceptor: Trader,
    var requester: Trader,
    var tradeDate: String
)

data class Trader(
    var uuid: String,
    var money: Long,
    var items: List<String>
)