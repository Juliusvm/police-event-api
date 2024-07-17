package com.julius.policeeventapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Profile("sync")
@RequiredArgsConstructor
public class ScheduledTasks {

    private final PoliceEventService policeEventService;
    Date date = Date.from(Instant.parse("2024-01-13T00:00:00Z"));

    // Convert Date to LocalDate
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


    @Scheduled(fixedRate = 15000)
    public void performTask() {

        String currentDate = localDate.toString();
        System.out.println(currentDate);
        policeEventService.getEvents(currentDate).block();

        localDate = localDate.plusDays(1);
    }
}
