package com.animalfarm.admin.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
@NoArgsConstructor
public class TradeHistoryDTO {
    private String id;
    private String acceptorName;
    private String acceptorUuid;
    private Long acceptorMoney;
    private List<ItemStack> acceptorItems;
    private String requesterName;
    private String requesterUuid;
    private List<ItemStack> requesterItems;
    private Long requesterMoney;
    private String tradeDate;

    @Builder
    public TradeHistoryDTO(String acceptorName, String acceptorUuid, Long acceptorMoney, List<ItemStack> acceptorItems,
                           String requesterName, String requesterUuid, List<ItemStack> requesterItems, Long requesterMoney,
                           String tradeDate) {
        this.acceptorName = acceptorName;
        this.acceptorUuid = acceptorUuid;
        this.acceptorMoney = acceptorMoney;
        this.acceptorItems = acceptorItems;
        this.requesterName = requesterName;
        this.requesterUuid = requesterUuid;
        this.requesterItems = requesterItems;
        this.requesterMoney = requesterMoney;
        this.tradeDate = tradeDate;
    }
}