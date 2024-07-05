package com.julius.policeeventapi.repository;

import com.julius.policeeventapi.model.EventWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class DispatchRepository {
    private final ReactiveMongoTemplate template;


    public Flux<EventWrapper> getEvents() {
        // Use template to perform reactive MongoDB operations
        return template.findAll(EventWrapper.class, "events"); // Example: Find all documents of type EventWrapper
    }
}
