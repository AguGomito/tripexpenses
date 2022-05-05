package com.globemedia.tripexp.controller;

import com.globemedia.tripexp.entity.TripEntity;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface ITripController {

    @GetMapping(value = "/all_trips")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<TripEntity>> retrieveAllTrips(@RequestHeader HttpHeaders httpHeaders, @Valid TripEntity tripDTO);

    @PostMapping(value = "/new_trip")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<TripEntity> newTrip(@RequestHeader HttpHeaders httpHeaders, @Valid TripEntity tripDTO);


}
