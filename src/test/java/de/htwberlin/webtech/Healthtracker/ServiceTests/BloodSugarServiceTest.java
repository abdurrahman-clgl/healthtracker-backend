package de.htwberlin.webtech.Healthtracker.ServiceTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodSugar;
import de.htwberlin.webtech.Healthtracker.Interface.BloodSugarRepository;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.BloodSugarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class BloodSugarServiceTest {

    @Autowired
    private BloodSugarService service;

    @MockBean
    private BloodSugarRepository repository;

    @Test
    @DisplayName("should find a blood sugar by its id")
    void testGetBloodSugarById() {
        // Test data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var bloodSugar = new BloodSugar(dateRecorded, 90);
        bloodSugar.setId(1L);

        // Mocking the repository
        doReturn(Optional.of(bloodSugar)).when(repository).findById(1L);

        // Actual result
        BloodSugar actual = service.get(1L);

        // Comparison
        assertEquals(bloodSugar.getBloodSugarLevel(), actual.getBloodSugarLevel());
        assertEquals(bloodSugar.getDateRecorded(), actual.getDateRecorded());
    }

    @Test
    @DisplayName("should save a blood sugar")
    void testSaveBloodSugar() {
        // Test data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var bloodSugar = new BloodSugar(dateRecorded, 90);
        bloodSugar.setId(1L);

        // Mocking the repository save method
        doReturn(bloodSugar).when(repository).save(bloodSugar);

        // Actual result
        BloodSugar actual = service.save(bloodSugar);

        // Comparison (if needed)
        assertEquals(bloodSugar, actual);
    }
}
