package com.globemedia.tripexp.dao;

import com.globemedia.tripexp.entity.ExpenseEntity;
import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.repository.IExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpenseDAO {

    @Autowired
    IExpenseRepository expenseRepository;

    public Iterable<ExpenseEntity> findByTripId(Long tripId) {
        TripEntity tripEntity = TripEntity.builder().id(tripId).build();

        try {
            return expenseRepository.findByTripEntity(tripEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null; //TODO: apply ExceptionHandler here
    }
}
