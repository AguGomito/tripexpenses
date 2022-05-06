package com.globemedia.tripexp.service;

import com.globemedia.tripexp.dao.ExpenseDAO;
import com.globemedia.tripexp.dao.TripDAO;
import com.globemedia.tripexp.dao.TripperDAO;
import com.globemedia.tripexp.dto.ExpenseDTO;
import com.globemedia.tripexp.dto.TripDTO;
import com.globemedia.tripexp.dto.TripperDTO;
import com.globemedia.tripexp.entity.ExpenseEntity;
import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.entity.TripperEntity;
import com.globemedia.tripexp.utils.Mapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService implements IExpenseService {

    @Autowired
    private TripDAO tripDAO;

    @Autowired
    private TripperDAO tripperDAO;

    @Autowired
    private ExpenseDAO expenseDAO;

    @Override
    public TripDTO retrieveAllExpensesByTrip(Long tripId) {
        Optional<TripEntity> tripEntity = tripDAO.findById(tripId);
        Iterable<TripperEntity> tripperEntityIterable = tripperDAO.findByTripEntityList(tripEntity.get());
        Iterable<ExpenseEntity> expenseEntityIterable = expenseDAO.findByTripId(tripId);

        List<TripperDTO> tripperDTOList = new ArrayList();
        tripperEntityIterable.forEach(tripperEntityIt -> {
            tripperDTOList.add(Mapper.tripperEntityToDTO(tripperEntityIt));
        });

        Double totalExpended = 0.0;

        for (TripperDTO tripperDTO : tripperDTOList) {
            List<ExpenseDTO> expenseDTOList = new ArrayList();
            for (ExpenseEntity expenseEntity : expenseEntityIterable) {

                if (tripperDTO.getId().equals(expenseEntity.getTripperEntity().getId())) {
                    tripperDTO.setExpendedAmount(tripperDTO.getExpendedAmount() + expenseEntity.getAmount());
                    totalExpended += expenseEntity.getAmount();
                    expenseDTOList.add(Mapper.expenseEntityToDTO(expenseEntity));
                }

            }
            tripperDTO.setExpensesDTO(expenseDTOList);
        }

        return Mapper.tripEntityToDTO(tripEntity.get(), totalExpended, tripperDTOList);
    }
}
