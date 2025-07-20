package de.htwberlin.webtech.Healthtracker.Serviceklassen;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.HeartRate;
import de.htwberlin.webtech.Healthtracker.Interface.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class HeartRateService {

    @Autowired
    HeartRateRepository heartRateRepository;

    public HeartRate save(HeartRate heartRate) {
        return heartRateRepository.save(heartRate);
    }

    public HeartRate getHeartRateById(Long id) {
        return heartRateRepository.findById(id).orElse(null);
    }

    public List<HeartRate> getAllHeartRates() {
        return (List<HeartRate>) heartRateRepository.findAll();
    }

    public void deleteHeartRate(Long id) {
        heartRateRepository.deleteById(id);
    }

    public long countHeartRates() {
        return heartRateRepository.count();
    }

    public HeartRate updateHeartRate(Long id, HeartRate updatedHeartRate) {
        HeartRate existingHeartRate = heartRateRepository.findById(id).orElse(null);
        if (existingHeartRate != null) {
            existingHeartRate.setDateRecorded(updatedHeartRate.getDateRecorded());
            existingHeartRate.setHeartRateValue(updatedHeartRate.getHeartRateValue());
            return heartRateRepository.save(existingHeartRate);
        }
        return null;
    }

    public double calculateAverageHeartRate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<HeartRate> heartRates = heartRateRepository.findByDateRecordedBetween(startDateTime, endDateTime);
        if (heartRates.isEmpty()) {
            return 0.0;
        }
        int sum = heartRates.stream().mapToInt(HeartRate::getHeartRateValue).sum();
        return (double) sum / heartRates.size();
    }



}

