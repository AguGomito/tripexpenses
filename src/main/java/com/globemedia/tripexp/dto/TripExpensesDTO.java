package com.globemedia.tripexp.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TripExpensesDTO {

    private TripDTO tripDTO;
    private List<DebtorDTO> debtorDTOList;
}
