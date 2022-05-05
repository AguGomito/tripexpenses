package com.globemedia.tripexp.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "trippers")
@Data
public class TripperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "trips_x_trippers",
        joinColumns = {@JoinColumn(name = "fk_tripper_id")},
        inverseJoinColumns = {@JoinColumn(name = "fk_trip_id")}
    )
    @NotNull
    private List<TripEntity> tripEntityList;
}
