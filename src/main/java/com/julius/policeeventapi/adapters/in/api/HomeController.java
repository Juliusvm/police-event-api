package com.julius.policeeventapi.adapters.in.api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {


    private final BuildProperties buildProperties;

    @GetMapping
    public ResponseEntity<String> getBuildProperties() {
        return ResponseEntity.ok(buildProperties.getVersion());
    }
}
