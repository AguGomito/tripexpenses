package com.globemedia.tripexp.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TripDTO {

    private Long id;
    private String name;
    private List<TripperDTO> tripperDTOList;
    private Double totalExpended;
}
