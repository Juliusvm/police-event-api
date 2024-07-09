package com.julius.policeeventapi.adapters.in.api;

import com.julius.policeeventapi.application.model.event.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {


    private final BuildProperties buildProperties;

    @GetMapping
    public ResponseEntity<String> getBuildProperties() {
        return ResponseEntity.ok(buildProperties.getVersion());
    }

    @PostMapping("sync")
    public ResponseEntity<String> sync() {
        return ResponseEntity.ok("hello");
    }
}
