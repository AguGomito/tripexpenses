package com.globemedia.tripexp.service;

import com.globemedia.tripexp.dto.ExpenseDTO;
import com.globemedia.tripexp.dto.TripDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IExpenseService {

    List<ExpenseDTO> retrieveAllExpensesFromTripId(Long tripId);
}
