package com.julius.policeeventapi.adapters.out.police;

import com.julius.policeeventapi.application.model.event.Event;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class PoliceApiClient {

    private final WebClient webClient;

    public PoliceApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.defaultHeader("user-agent", "PoliceEventAPI").baseUrl("https://polisen.se/api/events").build();
    }


    public Mono<List<Event>> getPoliceEvents(String date) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("DateTime", date)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Event>>() {
                }).doOnSuccess(System.out::println).doOnError(System.out::println);
    }
}