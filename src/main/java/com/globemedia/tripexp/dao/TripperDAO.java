package com.globemedia.tripexp.dao;

import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.entity.TripperEntity;
import com.globemedia.tripexp.repository.ITripperRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripperDAO {

    @Autowired
    ITripperRepository tripperRepository;

    public Iterable<TripperEntity> findByTripEntityList(TripEntity tripEntity) {
        return tripperRepository.findByTripEntityList(tripEntity);
    }
}
