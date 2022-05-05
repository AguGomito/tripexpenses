package com.globemedia.tripexp.service;

import com.globemedia.tripexp.entity.TripperEntity;
import com.globemedia.tripexp.repository.ITripperRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripperService implements ITripperService {

    @Autowired
    ITripperRepository ITripperRepository;

    @Override
    public List<TripperEntity> retrieveAll() {
        return ITripperRepository.findAll();
    }
}
