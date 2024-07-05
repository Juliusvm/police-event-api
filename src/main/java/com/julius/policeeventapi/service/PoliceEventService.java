package com.julius.policeeventapi.service;

import com.julius.policeeventapi.model.Event;
import com.julius.policeeventapi.model.EventWrapper;
import com.julius.policeeventapi.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PoliceEventService {

    private final EventRepository eventRepository;

    public Mono<EventWrapper> saveEventWrapper(EventWrapper event) {
        return eventRepository.save(event);
    }


    public Flux<EventWrapper> getEvents(String date) {
        return date != null ? eventRepository.findEventsById(date) : eventRepository.getEvents();
    }


}
