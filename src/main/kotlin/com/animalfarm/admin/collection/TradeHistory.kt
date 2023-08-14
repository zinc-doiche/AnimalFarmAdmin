package com.animalfarm.admin.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("tradeHistory")
data class TradeHistory(
    @Id
    var id: String? = null,
    @DBRef
    var acceptor: Trader? = null,
    @DBRef
    var requester: Trader? = null,
    var tradeDate: String? = null
)

data class Trader(
    @Id
    var uuid: String? = null,
    var money: Long? = null,
    var items: List<String>? = null
)