package com.globemedia.tripexp.repository;

import com.globemedia.tripexp.entity.TripEntity;
import com.globemedia.tripexp.entity.TripperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripperRepository extends CrudRepository<TripperEntity, Long> {

    Iterable<TripperEntity> findByTripEntityList(TripEntity tripEntity);
}
