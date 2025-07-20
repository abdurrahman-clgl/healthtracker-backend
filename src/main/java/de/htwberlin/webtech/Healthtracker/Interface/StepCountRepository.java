package de.htwberlin.webtech.Healthtracker.Interface;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.StepCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepCountRepository extends CrudRepository<StepCount, Long> {

}
