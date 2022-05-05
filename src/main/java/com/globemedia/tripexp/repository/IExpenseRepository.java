package com.globemedia.tripexp.repository;

import com.globemedia.tripexp.entity.ExpenseEntity;
import com.globemedia.tripexp.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

    Iterable<ExpenseEntity> findByTripEntity(TripEntity tripEntity);
}
