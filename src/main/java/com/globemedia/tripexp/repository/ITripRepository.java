package com.globemedia.tripexp.repository;

import com.globemedia.tripexp.entity.TripEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripRepository extends CrudRepository<TripEntity, Long> {

}
