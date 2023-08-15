package com.animalfarm.admin.controller;

import com.animalfarm.admin.collection.TradeHistory;
import com.animalfarm.admin.service.TradeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/api/*")
public class AdminRestController {
    private final TradeHistoryService tradeHistoryService;

    @GetMapping("trade/list")
    public Page<TradeHistory> admin(@PageableDefault Pageable pageable, String keyword) {
        return tradeHistoryService.getPage(pageable, keyword);
    }
}