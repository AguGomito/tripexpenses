package com.globemedia.tripexp.controller;

import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.entity.TripperEntity;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface ITripperController {

    @GetMapping(value = "/all_trippers")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<TripperEntity>> retrieveAllTrippers(@RequestHeader HttpHeaders httpHeaders, @Valid TripperEntity tripDTO);

    @PostMapping(value = "/new_tripper")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<TripperEntity> newTripper(@RequestHeader HttpHeaders httpHeaders, @Valid TripperEntity tripperEntity);
}
