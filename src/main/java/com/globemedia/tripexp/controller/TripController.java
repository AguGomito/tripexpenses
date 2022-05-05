package com.globemedia.tripexp.controller;

import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.service.ITripService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController implements ITripController {

    @Autowired
    ITripService tripService;

    @Override
        public ResponseEntity<List<TripEntity>> retrieveAllTrips(HttpHeaders httpHeaders, TripEntity tripDTO) {
        return new ResponseEntity(tripService.retrieveAllTrips(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TripEntity> newTrip(HttpHeaders httpHeaders, TripEntity tripEntity) {
        return null;
    }

}
