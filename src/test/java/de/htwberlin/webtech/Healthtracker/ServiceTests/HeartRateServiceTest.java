package de.htwberlin.webtech.Healthtracker.ServiceTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.HeartRate;
import de.htwberlin.webtech.Healthtracker.Interface.HeartRateRepository;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.HeartRateService;
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
public class HeartRateServiceTest {

    @Autowired
    private HeartRateService service;

    @MockBean
    private HeartRateRepository repository;

    @Test
    @DisplayName("should find a heart rate by its id")
    void testGetHeartRateById() {
        // Testdaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var heartRate = new HeartRate(dateRecorded, 70);
        heartRate.setId(42L);

        // Mocking des Repositories
        doReturn(Optional.of(heartRate)).when(repository).findById(42L);

        // Tatsächliches Ergebnis
        HeartRate actual = service.getHeartRateById(42L);

        // Vergleich
        assertEquals(actual.getHeartRateValue(), 70);
        assertEquals(actual.getDateRecorded(), dateRecorded);
    }

    @Test
    @DisplayName("should save a heart rate")
    void testSave() {
        // Testdaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var heartRate = new HeartRate(dateRecorded, 70);
        heartRate.setId(42L);

        // Mocking des Repositories
        doReturn(heartRate).when(repository).save(heartRate);

        // Tatsächliches Ergebnis
        HeartRate actual = service.save(heartRate);

        // Vergleich
        assertEquals(actual.getHeartRateValue(), 70);
        assertEquals(actual.getDateRecorded(), dateRecorded);
        assertEquals(actual.getId(), 42L);
    }

    @Test
    @DisplayName("should get all heart rates")
    void testGetAllHeartRates() {
        // Testdaten
        LocalDateTime dateRecorded1 = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var heartRate1 = new HeartRate(dateRecorded1, 70);
        heartRate1.setId(42L);

        LocalDateTime dateRecorded2 = LocalDateTime.of(2023, 1, 2, 11, 0, 0);
        var heartRate2 = new HeartRate(dateRecorded2, 75);
        heartRate2.setId(43L);

        List<HeartRate> heartRates = Arrays.asList(heartRate1, heartRate2);

        // Mocking des Repositories
        doReturn(heartRates).when(repository).findAll();

        // Tatsächliches Ergebnis
        List<HeartRate> actual = service.getAllHeartRates();

        // Vergleich
        assertEquals(2, actual.size());
        assertEquals(actual.get(0).getHeartRateValue(), 70);
        assertEquals(actual.get(0).getDateRecorded(), dateRecorded1);
        assertEquals(actual.get(0).getId(), 42L);
        assertEquals(actual.get(1).getHeartRateValue(), 75);
        assertEquals(actual.get(1).getDateRecorded(), dateRecorded2);
        assertEquals(actual.get(1).getId(), 43L);
    }
}
