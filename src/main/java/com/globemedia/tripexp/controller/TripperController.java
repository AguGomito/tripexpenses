package com.globemedia.tripexp.controller;

import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.entity.TripperEntity;
import com.globemedia.tripexp.service.ITripService;
import com.globemedia.tripexp.service.ITripperService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripperController implements ITripperController {

    @Autowired
    ITripperService tripperService;

    @Override
    public ResponseEntity<List<TripperEntity>> retrieveAllTrippers(HttpHeaders httpHeaders, TripperEntity tripperEntity) {
        return new ResponseEntity(tripperService.retrieveAll(), HttpStatus.OK);
    }

    public ResponseEntity<TripperEntity> newTripper(@RequestHeader HttpHeaders httpHeaders, @Valid TripperEntity tripperEntity) {
        return new ResponseEntity<>(tripperEntity, HttpStatus.OK);
    }

}
