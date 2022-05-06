package com.globemedia.tripexp.controller;

import com.globemedia.tripexp.dto.TripDTO;
import com.globemedia.tripexp.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController implements IExpenseController {

    @Autowired
    IExpenseService expenseService;

    @Override
    public ResponseEntity<TripDTO> retrieveAllExpensesByTrip(HttpHeaders httpHeaders, Long tripId) {
        return new ResponseEntity(expenseService.retrieveAllExpensesByTrip(tripId), HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<TripperEntity> newExpense(HttpHeaders httpHeaders, TripperEntity tripperEntity) {
//        return new ResponseEntity(expenseService.retrieveAllExpenses(), HttpStatus.OK);
//    }

}
