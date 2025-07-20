package de.htwberlin.webtech.Healthtracker.Serviceklassen;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.StepCount;
import de.htwberlin.webtech.Healthtracker.Interface.StepCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepCountService {

    @Autowired
    private StepCountRepository stepCountRepository;

    public StepCount save(StepCount stepCount) {
        return stepCountRepository.save(stepCount);
    }

    public StepCount getStepCountById(Long id) {
        return stepCountRepository.findById(id).orElse(null);
    }

    public List<StepCount> getAllStepCounts() {
        return (List<StepCount>) stepCountRepository.findAll();
    }

    public void deleteStepCount(Long id) {
        stepCountRepository.deleteById(id);
    }

    public StepCount updateStepCount(Long id, StepCount stepCount) {
        StepCount existingStepCount = stepCountRepository.findById(id).orElse(null);
        if (existingStepCount != null) {
            existingStepCount.setStepCount(stepCount.getStepCount());
            existingStepCount.setTargetStepCount(stepCount.getTargetStepCount());
            return stepCountRepository.save(existingStepCount);
        }
        return null;
    }
}