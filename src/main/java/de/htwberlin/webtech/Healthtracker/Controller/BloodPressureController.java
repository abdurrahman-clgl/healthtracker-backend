package de.htwberlin.webtech.Healthtracker.Controller;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodPressure;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.BloodPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/BloodPressures")
public class BloodPressureController {

    @Autowired
    private BloodPressureService bloodPressureService;

    @PostMapping("/bloodpressure")
    public BloodPressure createBloodPressure(@RequestBody BloodPressure bloodPressure) {
        return bloodPressureService.save(bloodPressure);
    }

    @GetMapping("/bloodpressure")
    public List<BloodPressure> getAllBloodPressures() {
        return bloodPressureService.getAllBloodPressures();
    }

    @GetMapping("/bloodpressure/{id}")
    public BloodPressure getBloodPressureById(@PathVariable Long id) {
        return bloodPressureService.getBloodPressureById(id);
    }

    @PutMapping("/bloodpressure/{id}")
    public BloodPressure updateBloodPressure(@PathVariable Long id, @RequestBody BloodPressure updatedBloodPressure) {
        return bloodPressureService.updateBloodPressure(id, updatedBloodPressure);
    }

    @DeleteMapping("/bloodpressure/{id}")
    public void deleteBloodPressure(@PathVariable Long id) {
        bloodPressureService.deleteBloodPressure(id);
    }
}
