package de.htwberlin.webtech.Healthtracker.Serviceklassen;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodPressure;
import de.htwberlin.webtech.Healthtracker.Interface.BloodPressureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodPressureService {

    @Autowired
    private BloodPressureRepository bloodPressureRepository;

    public BloodPressure save(BloodPressure bloodPressure) {
        return bloodPressureRepository.save(bloodPressure);
    }

    public BloodPressure getBloodPressureById(Long id) {
        return bloodPressureRepository.findById(id).orElse(null);
    }

    public List<BloodPressure> getAllBloodPressures() {
        return (List<BloodPressure>) bloodPressureRepository.findAll();
    }

    public void deleteBloodPressure(Long id) {
        bloodPressureRepository.deleteById(id);
    }

    public BloodPressure updateBloodPressure(Long id, BloodPressure updatedBloodPressure) {
        BloodPressure existingBloodPressure = bloodPressureRepository.findById(id).orElse(null);
        if (existingBloodPressure != null) {
            existingBloodPressure.setSystolicPressure(updatedBloodPressure.getSystolicPressure());
            existingBloodPressure.setDiastolicPressure(updatedBloodPressure.getDiastolicPressure());
            return bloodPressureRepository.save(existingBloodPressure);
        }
        return null;
    }
}
