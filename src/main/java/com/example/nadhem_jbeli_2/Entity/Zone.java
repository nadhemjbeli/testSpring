package com.example.nadhem_jbeli_2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ref;
    private float dimension;
    @OneToOne
    private Personnel receiver;
    @OneToMany
    private List<Personnel> senders;
    @ManyToOne
    @JsonIgnore
    private Parking parking;
}
