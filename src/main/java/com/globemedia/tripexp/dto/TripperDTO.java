package com.globemedia.tripexp.dto;

import java.util.List;
import lombok.Data;

@Data
public class TripperDTO {
    private Long id;
    private String name;
    private List<ExpenseDTO> expensesDTO;
}
