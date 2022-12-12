package com.example.nadhem_jbeli_2.Repositories;

import com.example.nadhem_jbeli_2.Entity.Parking;
import com.example.nadhem_jbeli_2.Entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    Zone getZoneByParking(Parking parking);
}
