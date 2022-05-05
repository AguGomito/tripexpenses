package com.globemedia.tripexp.service;

import com.globemedia.tripexp.entity.TripEntity;
import java.util.List;

public interface ITripService {

    List<TripEntity> retrieveAllTrips();
}
