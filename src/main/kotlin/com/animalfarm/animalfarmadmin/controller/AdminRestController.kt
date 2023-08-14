package com.animalfarm.animalfarmadmin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/api/*")
class AdminRestController {
    @GetMapping("")
    fun admin() {

    }
}