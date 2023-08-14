package com.animalfarm.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class AnimalFarmAdminApplication

fun main(args: Array<String>) {
    runApplication<AnimalFarmAdminApplication>(*args)
}
