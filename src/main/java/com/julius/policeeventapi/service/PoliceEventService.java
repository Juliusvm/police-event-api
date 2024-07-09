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


    public Mono<EventWrapper> getEvents(String date) {
        return eventRepository.findEventsById(date)
                .flatMap(event -> {
                    System.out.println("Event found: " + event);
                    return Mono.just(event);
                }).switchIfEmpty(Mono.defer(() -> {
                    System.out.println("No event found for date: " + date);
                    return syncEvents(date);
                }));
    }


    public Mono<EventWrapper> syncEvents(String date) {
        return policeApiClient.getPoliceEvents(date).flatMap(events -> {
            EventWrapper eventWrapper = new EventWrapper();
            eventWrapper.setEvents(events);
            eventWrapper.set_id(date);
            return saveEventWrapper(eventWrapper);
        });
    }


}
