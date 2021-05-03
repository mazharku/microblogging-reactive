package com.mazhar.reactive.configuration;

import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.ReactiveAuditorAware;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public class AuditorAwareImpl implements ReactiveAuditorAware<UUID> {
    @Override
    public Mono<UUID> getCurrentAuditor() {
         return Mono.just(UUID.fromString("e54a8b84-2558-4b76-80d9-9e78effe1758"));

    }

}
