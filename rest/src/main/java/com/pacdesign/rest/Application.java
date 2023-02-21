package com.pacdesign.rest;

import com.pacdesign.persistence.config.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.pacdesign.persistence.entity")
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableJpaRepositories(basePackages = "com.pacdesign.persistence.repository")
@SpringBootApplication(scanBasePackages = {"com.pacdesign.service", "com.pacdesign.persistence.repository"})
public class Application {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}