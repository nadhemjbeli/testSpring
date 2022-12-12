package com.example.nadhem_jbeli_2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String prenom;
    private String nom;
    private Integer age;
    @Temporal(TemporalType.DATE)
    private Date dateDeRecruitement;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Poste poste;

    @OneToOne(mappedBy = "receiver")
    private Zone zone;
}
