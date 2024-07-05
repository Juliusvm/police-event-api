package com.julius.policeeventapi.service;

import com.julius.policeeventapi.adapters.out.police.PoliceApiClient;
import com.julius.policeeventapi.application.model.event.Event;
import com.julius.policeeventapi.application.model.event.EventWrapper;
import com.julius.policeeventapi.adapters.out.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PoliceEventService {

    private final EventRepository eventRepository;
    private final PoliceApiClient policeApiClient;

    public Mono<EventWrapper> saveEventWrapper(EventWrapper event) {
        return eventRepository.save(event);
    }


    public Flux<EventWrapper> getEvents(String date) {
        return date != null ? eventRepository.findEventsById(date) : eventRepository.getEvents();
    }


    public Mono<List<Event>> syncEvents(String date) {
       return policeApiClient.getPoliceEvents(date).flatMap(events -> {
           EventWrapper eventWrapper = new EventWrapper();
           eventWrapper.setEvents(events);
           eventWrapper.set_id(date);
           return saveEventWrapper(eventWrapper).map(s -> events);
       });
    }



}
