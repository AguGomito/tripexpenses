package com.globemedia.tripexp.controller;

import com.globemedia.tripexp.dto.ExpenseDTO;
import com.globemedia.tripexp.entity.TripperEntity;
import com.globemedia.tripexp.service.IExpenseService;
import java.util.List;
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
    public ResponseEntity<List<ExpenseDTO>> retrieveAllExpensesFromTripId(HttpHeaders httpHeaders, Long tripId) {
        return new ResponseEntity(expenseService.retrieveAllExpensesFromTripId(tripId), HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<TripperEntity> newExpense(HttpHeaders httpHeaders, TripperEntity tripperEntity) {
//        return new ResponseEntity(expenseService.retrieveAllExpenses(), HttpStatus.OK);
//    }

}
