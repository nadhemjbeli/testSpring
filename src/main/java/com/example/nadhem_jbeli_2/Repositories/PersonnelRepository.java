package com.example.nadhem_jbeli_2.Repositories;

import com.example.nadhem_jbeli_2.Entity.Personnel;
import com.example.nadhem_jbeli_2.Entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
    List<Personnel> getAllByZone(Zone zone);
    @Query("select count(p) from Personnel p where p.poste = 'grade jour' and p.address = :ad  ")
    int findnb(String ad);
}
