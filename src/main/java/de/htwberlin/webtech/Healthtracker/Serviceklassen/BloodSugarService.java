package de.htwberlin.webtech.Healthtracker.Serviceklassen;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodSugar;
import de.htwberlin.webtech.Healthtracker.Interface.BloodSugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodSugarService {

    @Autowired
    private BloodSugarRepository bloodSugarRepository;

    public BloodSugar save(BloodSugar bloodSugar) {
        return bloodSugarRepository.save(bloodSugar);
    }

    public BloodSugar get(Long id) {
        return bloodSugarRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<BloodSugar> getAllBloodSugars() {
        return (List<BloodSugar>) bloodSugarRepository.findAll();
    }

    public void deleteBloodSugar(Long id) {
        bloodSugarRepository.deleteById(id);
    }

}
