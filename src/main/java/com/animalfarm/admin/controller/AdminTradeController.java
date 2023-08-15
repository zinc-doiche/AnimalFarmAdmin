package com.animalfarm.admin.controller;

import com.animalfarm.admin.collection.TradeHistory;
import com.animalfarm.admin.service.TradeHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/trade/*")
public class AdminTradeController {
    private final TradeHistoryService tradeHistoryService;

    @GetMapping("list")
    public void list() {;}

    @GetMapping("detail")
    public void detail(String id, Model model) {
        TradeHistory tradeHistory = tradeHistoryService.getTradeHistory(id);
        model.addAttribute("tradeHistory", tradeHistory);
//        model.addAttribute("requesterItems", tradeHistory.getRequester().getItems().stream().map(DocumentedItem::of).toList());
//        model.addAttribute("acceptorItems", tradeHistory.getRequester().getItems().stream().map(DocumentedItem::of).toList());
    }
}