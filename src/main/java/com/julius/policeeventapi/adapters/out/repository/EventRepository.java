package com.julius.policeeventapi.adapters.out.repository;
import com.julius.policeeventapi.application.model.event.EventWrapper;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface EventRepository extends ReactiveMongoRepository<EventWrapper, String> {

    @Query("events")
    Flux<EventWrapper> getEvents();

    @Query("{ '_id' : ?0 }")
    Flux<EventWrapper> findEventsById(String id);



}