package com.globemedia.tripexp.service;

import com.globemedia.tripexp.dto.TripDTO;
import com.globemedia.tripexp.dto.TripExpensesDTO;
import org.springframework.stereotype.Service;

@Service
public interface ITripExpenseService {

    TripExpensesDTO retrieveAllExpensesByTrip(Long tripId);
}
