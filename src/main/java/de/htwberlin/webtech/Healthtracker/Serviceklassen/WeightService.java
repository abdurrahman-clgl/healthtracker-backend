package de.htwberlin.webtech.Healthtracker.Serviceklassen;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.Weight;
import de.htwberlin.webtech.Healthtracker.Interface.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightService {

    @Autowired
    private WeightRepository weightRepository;

    public Weight save(Weight weight) {
        return weightRepository.save(weight);
    }

    public Weight get(Long id) {
        return weightRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Weight> getAllWeights() {
        return (List<Weight>) weightRepository.findAll();
    }

    public void deleteWeight(Long id) {
        weightRepository.deleteById(id);
    }

    public Weight updateWeight(Long id, Weight updatedWeight) {
        Weight existingWeight = weightRepository.findById(id).orElse(null);
        if (existingWeight != null) {
            existingWeight.setWeight(updatedWeight.getWeight());
            existingWeight.setDateRecorded(updatedWeight.getDateRecorded());
            existingWeight.setHeight(updatedWeight.getHeight());
            existingWeight.setWeightGoal(updatedWeight.getWeightGoal());
            existingWeight.setWeeklyGoal(updatedWeight.getWeeklyGoal());
            return weightRepository.save(existingWeight);
        }
        return null;
    }
}
