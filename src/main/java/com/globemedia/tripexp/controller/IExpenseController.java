package com.globemedia.tripexp.controller;

import com.globemedia.tripexp.dto.TripDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface IExpenseController {

    @GetMapping(value = "/all_expenses_by_trip/{tripId}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<TripDTO> retrieveAllExpensesByTrip(@RequestHeader HttpHeaders httpHeaders, @PathVariable Long tripId);

//    @PostMapping(value = "{trip}/{tripper}/new_expense")
//    @ResponseStatus(HttpStatus.OK)
//    ResponseEntity<TripperEntity> newExpense(@RequestHeader HttpHeaders httpHeaders, @Valid TripperEntity tripperEntity);

}
