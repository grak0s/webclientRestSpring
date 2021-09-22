package com.grak0s.webclientrest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class QuoteClient {

    private final WebClient client;

    // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
    // We can use it to create a dedicated `WebClient` for our component.
    public QuoteClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("https://quoters.apps.pcfone.io/api").build();
    }

    public Mono<Value> getMessage() {
        return this.client.get().uri("/random").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Quote.class)
                .map(Quote::getValue);
    }



}
