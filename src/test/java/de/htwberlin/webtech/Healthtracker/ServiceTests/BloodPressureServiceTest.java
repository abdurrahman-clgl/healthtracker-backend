package de.htwberlin.webtech.Healthtracker.ServiceTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodPressure;
import de.htwberlin.webtech.Healthtracker.Interface.BloodPressureRepository;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.BloodPressureService;
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
public class BloodPressureServiceTest {

    @Autowired
    private BloodPressureService service;

    @MockBean
    private BloodPressureRepository repository;

    @Test
    @DisplayName("should find a blood pressure by its id")
    void testGetBloodPressureById() {
        // Testdaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var bloodPressure = new BloodPressure(dateRecorded, 120, 80);
        bloodPressure.setId(42L);

        // Mocking des Repositories
        doReturn(Optional.of(bloodPressure)).when(repository).findById(42L);

        // Tatsächliches Ergebnis
        BloodPressure actual = service.getBloodPressureById(42L);

        // Vergleich
        assertEquals(actual.getSystolicPressure(), 120);
        assertEquals(actual.getDiastolicPressure(), 80);
        assertEquals(actual.getDateRecorded(), dateRecorded);
    }

    @Test
    @DisplayName("should save a blood pressure")
    void testSave() {
        // Testdaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var bloodPressure = new BloodPressure(dateRecorded, 120, 80);
        bloodPressure.setId(42L);

        // Mocking des Repositories
        doReturn(bloodPressure).when(repository).save(bloodPressure);

        // Tatsächliches Ergebnis
        BloodPressure actual = service.save(bloodPressure);

        // Vergleich
        assertEquals(actual.getSystolicPressure(), 120);
        assertEquals(actual.getDiastolicPressure(), 80);
        assertEquals(actual.getDateRecorded(), dateRecorded);
        assertEquals(actual.getId(), 42L);
    }

    @Test
    @DisplayName("should get all blood pressures")
    void testGetAllBloodPressures() {
        // Testdaten
        LocalDateTime dateRecorded1 = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var bloodPressure1 = new BloodPressure(dateRecorded1, 120, 80);
        bloodPressure1.setId(42L);

        LocalDateTime dateRecorded2 = LocalDateTime.of(2023, 1, 2, 11, 0, 0);
        var bloodPressure2 = new BloodPressure(dateRecorded2, 130, 85);
        bloodPressure2.setId(43L);

        List<BloodPressure> bloodPressures = Arrays.asList(bloodPressure1, bloodPressure2);

        // Mocking des Repositories
        doReturn(bloodPressures).when(repository).findAll();

        // Tatsächliches Ergebnis
        List<BloodPressure> actual = service.getAllBloodPressures();

        // Vergleich
        assertEquals(2, actual.size());
        assertEquals(actual.get(0).getSystolicPressure(), 120);
        assertEquals(actual.get(0).getDiastolicPressure(), 80);
        assertEquals(actual.get(0).getDateRecorded(), dateRecorded1);
        assertEquals(actual.get(0).getId(), 42L);
        assertEquals(actual.get(1).getSystolicPressure(), 130);
        assertEquals(actual.get(1).getDiastolicPressure(), 85);
        assertEquals(actual.get(1).getDateRecorded(), dateRecorded2);
        assertEquals(actual.get(1).getId(), 43L);
    }
}
