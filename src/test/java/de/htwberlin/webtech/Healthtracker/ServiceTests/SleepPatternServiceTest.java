package de.htwberlin.webtech.Healthtracker.ServiceTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.SleepPattern;
import de.htwberlin.webtech.Healthtracker.Interface.SleepPatternRepository;
import de.htwberlin.webtech.Healthtracker.Serviceklassen.SleepPatternService;
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
public class SleepPatternServiceTest {

    @Autowired
    private SleepPatternService service;

    @MockBean
    private SleepPatternRepository repository;

    @Test
    @DisplayName("should find a sleep pattern by its id")
    void testGetSleepPatternById() {
        // Test data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var sleepPattern = new SleepPattern(dateRecorded, 8, 3, 5, 2);
        sleepPattern.setId(42L);

        // Mocking the repository
        doReturn(Optional.of(sleepPattern)).when(repository).findById(42L);

        // Actual result
        SleepPattern actual = service.get(42L);

        // Comparison
        assertEquals(actual.getSleepDuration(), 8);
        assertEquals(actual.getDateRecorded(), dateRecorded);
    }

    @Test
    @DisplayName("should save a sleep pattern")
    void testSave() {
        // Test data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        var sleepPattern = new SleepPattern(dateRecorded, 8, 3, 5, 2);
        sleepPattern.setId(42L);

        // Mocking the repository
        doReturn(sleepPattern).when(repository).save(sleepPattern);

        // Actual result
        SleepPattern actual = service.save(sleepPattern);

        //
    }
}