package com.globemedia.tripexp.service;

import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.repository.ITripRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService implements ITripService {

    @Autowired
    ITripRepository ITripRepository;

    @Override
    public List<TripEntity> retrieveAllTrips() {
        return ITripRepository.findAll();
    }
}
