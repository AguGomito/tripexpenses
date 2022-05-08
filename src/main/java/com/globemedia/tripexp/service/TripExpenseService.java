package com.globemedia.tripexp.service;

import com.globemedia.tripexp.dao.ExpenseDAO;
import com.globemedia.tripexp.dao.TripDAO;
import com.globemedia.tripexp.dao.TripperDAO;
import com.globemedia.tripexp.dto.DebtDTO;
import com.globemedia.tripexp.dto.DebtorDTO;
import com.globemedia.tripexp.dto.ExpenseDTO;
import com.globemedia.tripexp.dto.TripDTO;
import com.globemedia.tripexp.dto.TripExpensesDTO;
import com.globemedia.tripexp.dto.TripperDTO;
import com.globemedia.tripexp.entity.ExpenseEntity;
import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.entity.TripperEntity;
import com.globemedia.tripexp.utils.Mapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripExpenseService implements ITripExpenseService {

    @Autowired
    private TripDAO tripDAO;

    @Autowired
    private TripperDAO tripperDAO;

    @Autowired
    private ExpenseDAO expenseDAO;

    @Override
    public TripExpensesDTO retrieveAllExpensesByTrip(Long tripId) {
        Optional<TripEntity> tripEntity = tripDAO.findById(tripId);
        Iterable<TripperEntity> tripperEntityIterable = tripperDAO.findByTripEntityList(tripEntity.get());
        Iterable<ExpenseEntity> expenseEntityIterable = expenseDAO.findByTripId(tripId);
        Double totalExpended = 0.0;

        List<TripperDTO> tripperDTOList = new ArrayList();
        tripperEntityIterable.forEach(tripperEntityIt -> {
            tripperDTOList.add(Mapper.tripperEntityToDTO(tripperEntityIt));
        });

        for (TripperDTO tripperDTO : tripperDTOList) {
            List<ExpenseDTO> expenseDTOList = new ArrayList();

            for (ExpenseEntity expenseEntity : expenseEntityIterable) {

                if (tripperDTO.getId().equals(expenseEntity.getTripperEntity().getId())) {
                    totalExpended += expenseEntity.getAmount();
                    tripperDTO.setExpendedAmount(tripperDTO.getExpendedAmount() + expenseEntity.getAmount());
                    expenseDTOList.add(Mapper.expenseEntityToDTO(expenseEntity));
                }

            }
            tripperDTO.setExpensesDTO(expenseDTOList);
        }

        Double expensesForEach = totalExpended / tripperDTOList.size();
        tripperDTOList.forEach(tripperDTO -> {
            tripperDTO.setTotalEach(expensesForEach);
            tripperDTO.setDifferenceAmount(tripperDTO.getExpendedAmount() - expensesForEach);
        });

        TripDTO tripDTO = Mapper.tripEntityToDTO(tripEntity.get(), totalExpended, tripperDTOList);

        List<DebtorDTO> debtorDTO = whoOwesWhomCalculator(tripDTO);

        return TripExpensesDTO.builder().tripDTO(tripDTO).debtorDTOList(debtorDTO).build();
    }

    private List<DebtorDTO> whoOwesWhomCalculator(TripDTO tripDTO) {
        List<DebtorDTO> debtorDTOList = new ArrayList<>();
        tripDTO.getTripperDTOList().forEach(tripperDTO -> {
            debtorDTOList.add(
                DebtorDTO
                    .builder()
                    .name(tripperDTO.getName())
                    .totalOwe(tripperDTO.getDifferenceAmount())
                    .build());
        });
        while (!allZeros(debtorDTOList)) {
            DebtorDTO owesTheMost = whoOwesTheMost(debtorDTOList);
            DebtorDTO needsToGetPaid = whoNeedsToGetPaid(debtorDTOList);

            Double checker = owesTheMost.getTotalOwe() + needsToGetPaid.getTotalOwe();

            if (checker > 0.0) {
                owesTheMost.addDebtDTOList(DebtDTO.builder().owesTo(needsToGetPaid.getName()).owesDouble(owesTheMost.getTotalOwe()).build());
                needsToGetPaid.setTotalOwe(checker);
                owesTheMost.setTotalOwe(0.0);
            } else {
                owesTheMost.addDebtDTOList(DebtDTO.builder().owesTo(needsToGetPaid.getName()).owesDouble(-1 * needsToGetPaid.getTotalOwe()).build());
                owesTheMost.setTotalOwe(checker);
                needsToGetPaid.setTotalOwe(0.0);
            }

        }
        return debtorDTOList;
    }

    private Boolean allZeros(List<DebtorDTO> debtorDTOList) {
        for (DebtorDTO debtorDTO : debtorDTOList) {
            if (debtorDTO.getTotalOwe() != 0.0) {
                return false;
            }
        }
        return true;
    }

    private DebtorDTO whoOwesTheMost(List<DebtorDTO> debtorDTOList) {
        AtomicReference<DebtorDTO> owesTheMost = new AtomicReference<>(debtorDTOList.get(0));
        debtorDTOList.forEach(debtorDTO -> {
            if (debtorDTO.getTotalOwe() < owesTheMost.get().getTotalOwe()) {
                owesTheMost.set(debtorDTO);
            }
        });
        return owesTheMost.get();
    }

    private DebtorDTO whoNeedsToGetPaid(List<DebtorDTO> debtorDTOList) {
        AtomicReference<DebtorDTO> needsToGetPaid = new AtomicReference<>(debtorDTOList.get(0));
        debtorDTOList.forEach(debtorDTO -> {
            if (debtorDTO.getTotalOwe() > needsToGetPaid.get().getTotalOwe()) {
                needsToGetPaid.set(debtorDTO);
            }
        });
        return needsToGetPaid.get();
    }

}
