package de.htwberlin.webtech.Healthtracker.Interface;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodPressure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface BloodPressureRepository extends CrudRepository<BloodPressure, Long> {

    }

