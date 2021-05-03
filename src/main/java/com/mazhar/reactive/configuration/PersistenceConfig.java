package com.mazhar.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import java.util.UUID;

@Configuration
@EnableR2dbcAuditing(auditorAwareRef = "auditorAware")
public class PersistenceConfig {

    @Bean
    public ReactiveAuditorAware<UUID> auditorAware(){
        return new AuditorAwareImpl();
    }
}
