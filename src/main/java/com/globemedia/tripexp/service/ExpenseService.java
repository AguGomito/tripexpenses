package com.globemedia.tripexp.service;

import com.globemedia.tripexp.dao.ExpenseDAO;
import com.globemedia.tripexp.dto.ExpenseDTO;
import com.globemedia.tripexp.dto.TripDTO;
import com.globemedia.tripexp.entity.ExpenseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService implements IExpenseService {

    @Autowired
    private ExpenseDAO expenseDAO;

    @Override
    public List<ExpenseDTO> retrieveAllExpensesFromTripId(Long tripId) {
        Iterable<ExpenseEntity> expenseEntity = expenseDAO.findByTripId(tripId);

        List<ExpenseDTO> expenseDTOList = new ArrayList<>();
        expenseEntity.forEach(expEnt -> expenseDTOList.add(
            ExpenseDTO.builder()
                .id(expEnt.getId())
                .detail(expEnt.getDetail())
                .amount(expEnt.getAmount())
                .build()));

        return expenseDTOList;
    }
}
