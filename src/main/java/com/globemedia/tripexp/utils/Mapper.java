package com.globemedia.tripexp.utils;

import com.globemedia.tripexp.dto.ExpenseDTO;
import com.globemedia.tripexp.dto.TripDTO;
import com.globemedia.tripexp.dto.TripperDTO;
import com.globemedia.tripexp.entity.ExpenseEntity;
import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.entity.TripperEntity;
import java.util.List;

public class Mapper {

    public static TripDTO tripEntityToDTO(TripEntity tripEntity, Double totalExpended, List<TripperDTO> tripperDTO) {
        return TripDTO
            .builder()
            .id(tripEntity.getId())
            .name(tripEntity.getName())
            .tripperDTOList(tripperDTO)
            .totalExpended(totalExpended)
            .build();
    }

    public static TripperDTO tripperEntityToDTO(TripperEntity tripperEntity){
        return TripperDTO
            .builder()
            .id(tripperEntity.getId())
            .name(tripperEntity.getName())
            .expendedAmount(0.0)
            .build();
    }

    public static ExpenseDTO expenseEntityToDTO(ExpenseEntity expenseEntity){
        return ExpenseDTO
            .builder()
            .id(expenseEntity.getId())
            .detail(expenseEntity.getDetail())
            .amount(expenseEntity.getAmount())
            .build();
    }
}
