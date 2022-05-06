package com.globemedia.tripexp.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TripperDTO {

    private Long id;
    private String name;
    private List<ExpenseDTO> expensesDTO;
    private Double expendedAmount;
}
