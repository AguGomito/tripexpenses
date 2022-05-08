package com.globemedia.tripexp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DebtDTO {
    String owesTo;
    Double owesDouble;
}
