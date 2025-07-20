package de.htwberlin.webtech.Healthtracker.Controller;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.HeartRate;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://healthtracker-frontend.onrender.com" })
public class HeartRateController {

    @Autowired
    HeartRateService heartRateService;

    @PostMapping("/HeartRates")
    public HeartRate createHeartRate(@RequestBody HeartRate heartRate) {
        return heartRateService.save(heartRate);
    }

    @GetMapping("/HeartRates")
    public List<HeartRate> getHeartRates() {
        return heartRateService.getAllHeartRates();
    }

    @GetMapping("/HeartRates/{id}")
    public HeartRate getHeartRateById(@PathVariable Long id) {
        return heartRateService.getHeartRateById(id);
    }

    @PutMapping("/HeartRates/{id}")
    public HeartRate updateHeartRate(@PathVariable Long id, @RequestBody HeartRate updatedHeartRate) {
        return heartRateService.updateHeartRate(id, updatedHeartRate);
    }

    @DeleteMapping("/HeartRates/{id}")
    public void deleteHeartRate(@PathVariable Long id) {
        heartRateService.deleteHeartRate(id);
    }

    @GetMapping("/HeartRates/average")
    public double calculateAverageHeartRate(
            @RequestParam("startDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam("endDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {
        return heartRateService.calculateAverageHeartRate(startDateTime, endDateTime);
    }

    @GetMapping("/HeartRates/count")
    public long countHeartRates() {
        return heartRateService.countHeartRates();
    }
}

