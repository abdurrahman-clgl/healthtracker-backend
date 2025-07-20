package de.htwberlin.webtech.Healthtracker.Controller;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.Weight;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/Weight")
public class WeightController {

    @Autowired
    private WeightService weightService;

    @PostMapping("/weights")
    public Weight createWeight(@RequestBody Weight weight) {
        return weightService.save(weight);
    }

    @GetMapping("/weights")
    public List<Weight> getWeights() {
        return weightService.getAllWeights();
    }

    @GetMapping("/weights/{id}")
    public Weight getWeightById(@PathVariable Long id) {
        return weightService.get(id);
    }

    @DeleteMapping("/weights/{id}")
    public void deleteWeight(@PathVariable Long id) {
        weightService.deleteWeight(id);
    }
}
