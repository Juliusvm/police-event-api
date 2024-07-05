package com.julius.policeeventapi.controllers;

import com.julius.policeeventapi.model.EventWrapper;
import com.julius.policeeventapi.service.PoliceEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    public final PoliceEventService policeEventService;

    @GetMapping()
    public ResponseEntity<Flux<String>> getEvents(@RequestParam(required = false) String date) {
        Flux<String> events = policeEventService.getEvents(date).map(Object::toString);
        return ResponseEntity.ok(events);
    }

    @PostMapping()
    public ResponseEntity<Mono<EventWrapper>> saveEvents(@RequestBody EventWrapper eventWrappers) {
        return ResponseEntity.ok(policeEventService.saveEventWrapper(eventWrappers));
    }

}
