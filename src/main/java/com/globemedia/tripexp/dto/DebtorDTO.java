package com.globemedia.tripexp.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DebtorDTO {

    String name;
    Double totalOwe;
    List<DebtDTO> debtDTOList;

    public void addDebtDTOList (DebtDTO debtDTO) {
        if (debtDTOList == null) {
            debtDTOList = new ArrayList<>();
        }
        debtDTOList.add(debtDTO);
    }

}
