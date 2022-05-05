package com.globemedia.tripexp.dto;

import java.util.List;
import lombok.Data;

@Data
public class TripDTO {

    private Long id;
    private String name;
    private List<TripperDTO> tripperDTOList;
}
