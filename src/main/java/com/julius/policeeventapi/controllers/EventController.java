package com.julius.policeeventapi.controllers;
import com.julius.policeeventapi.model.EventWrapper;
import com.julius.policeeventapi.service.PoliceEventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class EventController {

    public final PoliceEventService policeEventService;

    @GetMapping("events")
    public ResponseEntity<Flux<String>> getEvents(@RequestParam(required = false) String date){
        Flux<String> events = policeEventService.getEvents(date).map(Object::toString);
        return ResponseEntity.ok(events);
    }

    @PostMapping("events")
    public ResponseEntity<Mono<EventWrapper>> saveEvents(@RequestBody EventWrapper eventWrappers){
        return ResponseEntity.ok(policeEventService.saveEventWrapper(eventWrappers));
    }

}
