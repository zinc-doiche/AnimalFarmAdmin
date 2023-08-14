package com.animalfarm.admin.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/trade/*")
class AdminTradeController {
    @GetMapping("list")
    fun list() {;}

    @GetMapping("detail")
    fun detail() {;}
}