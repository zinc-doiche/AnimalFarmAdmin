package com.animalfarm.admin.domain

import org.bukkit.inventory.ItemStack

data class TradeHistoryDTO(
    val id: String,
    val acceptorName: String,
    val acceptorUuid: String,
    val acceptorMoney: Long,
    val acceptorItems: List<ItemStack>,
    val requesterName: String,
    val requesterUuid: String,
    val requesterItems: List<ItemStack>,
    val requesterMoney: Long,
    val tradeDate: String
)