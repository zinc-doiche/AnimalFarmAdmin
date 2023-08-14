package com.animalfarm.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AnimalFarmAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimalFarmAdminApplication.class, args);
    }
}