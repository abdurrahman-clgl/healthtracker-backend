package de.htwberlin.webtech.Healthtracker.Interface;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.HeartRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HeartRateRepository extends CrudRepository<HeartRate, Long> {

    List<HeartRate> findByDateRecordedBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
