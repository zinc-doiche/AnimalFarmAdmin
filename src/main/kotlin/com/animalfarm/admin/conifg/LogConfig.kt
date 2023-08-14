package com.animalfarm.admin.conifg

import com.animalfarm.admin.AnimalFarmAdminApplication
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class LogConfig {
    @Bean
    fun logger(): Logger = LoggerFactory.getLogger(AnimalFarmAdminApplication::class.java)
}