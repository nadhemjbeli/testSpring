package com.example.nadhem_jbeli_2.Controller;

import com.example.nadhem_jbeli_2.Entity.Parking;
import com.example.nadhem_jbeli_2.Entity.Personnel;
import com.example.nadhem_jbeli_2.Entity.Zone;
import com.example.nadhem_jbeli_2.Repositories.ParkingRepository;
import com.example.nadhem_jbeli_2.Repositories.PersonnelRepository;
import com.example.nadhem_jbeli_2.Repositories.ZoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projet")
@AllArgsConstructor
public class BaseController {
    @Autowired
    PersonnelRepository personnelRepository;
    @Autowired
    ParkingRepository parkingRepository;
    @Autowired
    ZoneRepository zoneRepository;
    @PostMapping("personnel/add")
    private Personnel addPersonnel(@RequestBody Personnel personnel){
        return personnelRepository.save(personnel);

    }
    @PostMapping("parkingZones/add")
    private Parking addParkingetZones(@RequestBody Parking parking){

        return parkingRepository.save(parking);


    }
    @PutMapping("affecterPersonnelZone/{idzone}/{idGrade}")
    private void affecterPersonnelZone(@PathVariable int idzone, @PathVariable int idGrade){
        Personnel personnel = personnelRepository.findById(idGrade).orElse(null);

        Zone zone = zoneRepository.findById(idzone).orElse(null);


        if(zone!=null){
            List<Personnel> personnels = zone.getSenders() ;
            personnels.add(personnel);
            zone.setSenders(personnels);

            zoneRepository.save(zone);
            System.out.println(personnel.getNom()+" affecté à "+zone.getRef());
        }


    }
    @GetMapping("getAllPersonnelByParking")
    private List<Personnel> getAllPersonnelByParking(@RequestBody Parking parking){
        Zone zone = this.zoneRepository.getZoneByParking(parking);
        System.out.println(zone);
        List<Personnel> personnels = this.personnelRepository.getAllByZone(zone);
        return personnels;

    }
    @GetMapping("getnb")
    private int nombreGardeJour(String adress){

        return personnelRepository.findnb(adress);

    }

}
