package com.globemedia.tripexp.dao;

import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.repository.ITripRepository;
import java.util.Optional;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripDAO {

    @Autowired
    ITripRepository tripRepository;

    public Optional<TripEntity> findById(Long tripId) {
        try {
            return tripRepository.findById(tripId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null; //TODO: apply ExceptionHandler here
    }
}
