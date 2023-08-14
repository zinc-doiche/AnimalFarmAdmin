package com.animalfarm.admin.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@Slf4j
@RequestMapping("/admin/trade/*")
class AdminTradeController {
    @GetMapping("list")
    fun list() {;}

    @GetMapping("detail")
    fun detail() {;}
}