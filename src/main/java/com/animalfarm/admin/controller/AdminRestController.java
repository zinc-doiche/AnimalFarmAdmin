package com.animalfarm.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api/*")
public class AdminRestController {
    @GetMapping("")
    public void admin() {;}
}