package com.globemedia.tripexp.repository;

import com.globemedia.tripexp.entity.TripperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripperRepository extends JpaRepository<TripperEntity, Long> {

}
