package com.animalfarm.admin.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping("")
    fun main(): String = "/admin/trade/list"
}