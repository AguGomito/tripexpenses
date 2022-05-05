package com.globemedia.tripexp.repository;

import com.globemedia.tripexp.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripRepository extends JpaRepository<TripEntity, Long> {

}
