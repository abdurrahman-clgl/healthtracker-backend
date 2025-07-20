package de.htwberlin.webtech.Healthtracker.EntitäsTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.StepCount;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepCountEntitätsTest {

    @Test
    void testToString() {

        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        int stepCount = 10000;
        int targetStepCount = 12000;

        StepCount stepCount1 = new StepCount(dateRecorded, stepCount, targetStepCount);
        stepCount1.setId(42L);

        String expected = "StepCount{id=42, dateRecorded=2023-01-01T10:00, stepCount=10000, targetStepCount=12000}";

        String actual = stepCount1.toString();

        assertEquals(expected, actual);
    }
}
