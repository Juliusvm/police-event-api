package com.julius.policeeventapi.adapters.in.api;

import com.julius.policeeventapi.application.model.event.Event;
import com.julius.policeeventapi.application.model.event.EventWrapper;
import com.julius.policeeventapi.service.PoliceEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

    @PostMapping("sync")
    public ResponseEntity<Mono<List<Event>>> sync(@RequestParam String date) {
        return ResponseEntity.ok(policeEventService.syncEvents(date));
    }
}
