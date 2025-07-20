package de.htwberlin.webtech.Healthtracker.Controller;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.StepCount;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.StepCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/StepCounts")
public class StepCountController {

    @Autowired
    StepCountService stepCountService;

    @PostMapping("/stepcount")
    public StepCount createStepCount(@RequestBody StepCount stepCount) {
        return stepCountService.save(stepCount);
    }

    @GetMapping("/stepcount")
    public List<StepCount> getAllStepCounts() {
        return stepCountService.getAllStepCounts();
    }

    @GetMapping("/stepcount/{id}")
    public StepCount getStepCountById(@PathVariable Long id) {
        return stepCountService.getStepCountById(id);
    }

    @DeleteMapping("/stepcount/{id}")
    public void deleteStepCount(@PathVariable Long id) {
        stepCountService.deleteStepCount(id);
    }

    @GetMapping("/stepcount/{id}/difference")
    public int getDifference(@PathVariable Long id) {
        StepCount stepCount = stepCountService.getStepCountById(id);
        return stepCount.getDifference();
    }

    @PutMapping("/stepcount/{id}")
    public StepCount updateStepCount(@PathVariable Long id, @RequestBody StepCount stepCount) {
        return stepCountService.updateStepCount(id, stepCount);
    }
}


