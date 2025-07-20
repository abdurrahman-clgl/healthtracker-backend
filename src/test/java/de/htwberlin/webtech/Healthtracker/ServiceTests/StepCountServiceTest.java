package de.htwberlin.webtech.Healthtracker.ServiceTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.StepCount;
import de.htwberlin.webtech.Healthtracker.Interface.StepCountRepository;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.StepCountService;
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
public class StepCountServiceTest {

    @Autowired
    private StepCountService service;

    @MockBean
    private StepCountRepository repository;

    @Test
    @DisplayName("should find a step count by its id")
    void testGetStepCountById() {
        // Testdaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var stepCount = new StepCount(dateRecorded, 10000, 12000);
        stepCount.setId(42L);

        // Mocking des Repositories
        doReturn(Optional.of(stepCount)).when(repository).findById(42L);

        // Tatsächliches Ergebnis
        StepCount actual = service.getStepCountById(42L);

        // Vergleich
        assertEquals(actual.getStepCount(), 10000);
        assertEquals(actual.getDateRecorded(), dateRecorded);
    }

    @Test
    @DisplayName("should save a step count")
    void testSave() {
        // Testdaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var stepCount = new StepCount(dateRecorded, 10000, 12000);
        stepCount.setId(42L);

        // Mocking des Repositories
        doReturn(stepCount).when(repository).save(stepCount);

        // Tatsächliches Ergebnis
        StepCount actual = service.save(stepCount);

        // Vergleich
        assertEquals(actual.getStepCount(), 10000);
        assertEquals(actual.getDateRecorded(), dateRecorded);
        assertEquals(actual.getId(), 42L);
    }

    @Test
    @DisplayName("should get all step counts")
    void testGetAllStepCounts() {
        // Testdaten
        LocalDateTime dateRecorded1 = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var stepCount1 = new StepCount(dateRecorded1, 10000, 12000);
        stepCount1.setId(42L);

        LocalDateTime dateRecorded2 = LocalDateTime.of(2023, 1, 2, 11, 0, 0);
        var stepCount2 = new StepCount(dateRecorded2, 15000, 12000);
        stepCount2.setId(43L);

        List<StepCount> stepCounts = Arrays.asList(stepCount1, stepCount2);

        // Mocking des Repositories
        doReturn(stepCounts).when(repository).findAll();

        // Tatsächliches Ergebnis
        List<StepCount> actual = service.getAllStepCounts();

        // Vergleich
        assertEquals(2, actual.size());
        assertEquals(actual.get(0).getStepCount(), 10000);
        assertEquals(actual.get(0).getDateRecorded(), dateRecorded1);
        assertEquals(actual.get(0).getId(), 42L);
        assertEquals(actual.get(1).getStepCount(), 15000);
        assertEquals(actual.get(1).getDateRecorded(), dateRecorded2);
        assertEquals(actual.get(1).getId(), 43L);
    }
}
