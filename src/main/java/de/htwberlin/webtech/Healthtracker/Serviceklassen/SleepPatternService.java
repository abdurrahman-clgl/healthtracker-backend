package de.htwberlin.webtech.Healthtracker.Serviceklassen;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.SleepPattern;
import de.htwberlin.webtech.Healthtracker.Interface.SleepPatternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepPatternService {

    @Autowired
    SleepPatternRepository sleepPatternRepository;

    public SleepPattern save(SleepPattern sleepPattern) {
        sleepPattern.updateSleepQuality();
        return sleepPatternRepository.save(sleepPattern);
    }

    public SleepPattern get(Long id) {
        return sleepPatternRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<SleepPattern> getAllSleepPatterns() {
        return (List<SleepPattern>) sleepPatternRepository.findAll();
    }

    public void deleteSleepPattern(Long id) {
        sleepPatternRepository.deleteById(id);
    }
}
