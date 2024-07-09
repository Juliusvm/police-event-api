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
    public Mono<ResponseEntity<List<Event>>> getEvents(@RequestParam(required = false) String date) {
        return policeEventService.getEvents(date).map(s -> s.events).map(ResponseEntity::ok);
    }

    @PostMapping("sync")
    public Mono<ResponseEntity<EventWrapper>> sync(@RequestParam String date) {
        return policeEventService.syncEvents(date).map(ResponseEntity::ok);
    }
}
