package com.pacdesign.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.pacdesign.persistence.entity")
@EnableJpaRepositories(basePackages = "com.pacdesign.persistence.repository")
@SpringBootApplication(scanBasePackages = {"com.pacdesign.service", "com.pacdesign.persistence.repository"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}