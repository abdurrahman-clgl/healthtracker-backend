package de.htwberlin.webtech.Healthtracker.EntitäsTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.SleepPattern;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SleepPatternEntitätsTest {

    @Test
    void testToString() {
        // Input data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        double sleepDuration = 8;
        double lightSleepDuration = 3;
        double deepSleepDuration = 5;
        int interruptions = 2;

        // Setup the "System Under Test"
        SleepPattern sleepPattern = new SleepPattern(dateRecorded, sleepDuration, lightSleepDuration, deepSleepDuration, interruptions);
        sleepPattern.setId(42L);

        // Expected result
        String expected = "SleepPattern{id=42, dateRecorded=2023-01-01T10:00, sleepDuration=8.0, lightSleepDuration=3.0, deepSleepDuration=5.0, interruptions=2, sleepQuality=75.0}";

        // Actual result
        String actual = sleepPattern.toString();

        // Comparison
        assertEquals(expected, actual);
    }

    @Test
    void testCalculateSleepQuality() {
        // Input data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        double sleepDuration = 8;
        double lightSleepDuration = 3;
        double deepSleepDuration = 5;
        int interruptions = 2;


        SleepPattern sleepPattern = new SleepPattern(dateRecorded, sleepDuration, lightSleepDuration, deepSleepDuration, interruptions);

        // Expected result
        double expectedQuality = (sleepDuration + deepSleepDuration - interruptions * 0.5) / (sleepDuration + lightSleepDuration + deepSleepDuration) * 100;

        // Actual result
        double actualQuality = sleepPattern.calculateSleepQuality();

        // Comparison
        assertEquals(expectedQuality, actualQuality);
    }
}
