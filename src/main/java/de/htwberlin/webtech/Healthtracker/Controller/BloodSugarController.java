package de.htwberlin.webtech.Healthtracker.Controller;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodSugar;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.BloodSugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/BloodSugar")
public class BloodSugarController {

    @Autowired
    private BloodSugarService bloodSugarService;

    @PostMapping("/bloodsugar")
    public BloodSugar createBloodSugar(@RequestBody BloodSugar bloodSugar) {
        return bloodSugarService.save(bloodSugar);
    }

    @GetMapping("/bloodsugar")
    public List<BloodSugar> getBloodSugars() {
        return bloodSugarService.getAllBloodSugars();
    }

    @GetMapping("/bloodsugar/{id}")
    public BloodSugar getBloodSugarById(@PathVariable Long id) {
        return bloodSugarService.get(id);
    }

    @DeleteMapping("/bloodsugar/{id}")
    public void deleteBloodSugar(@PathVariable Long id) {
        bloodSugarService.deleteBloodSugar(id);
    }
}
