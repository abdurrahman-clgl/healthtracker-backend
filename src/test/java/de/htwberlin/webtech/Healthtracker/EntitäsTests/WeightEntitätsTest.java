package de.htwberlin.webtech.Healthtracker.EntitäsTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.Weight;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightEntitätsTest {

    @Test
    void testToString() {
        // Input data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        double weightValue = 70.5;
        double height = 1.75;
        double weightGoal = 68.0;
        double weeklyGoal = 0.5;

        // Setup the "System Under Test"
        Weight weight = new Weight(dateRecorded, weightValue, height, weightGoal, weeklyGoal);
        weight.setId(1L);

        // Expected result
        String expected = "Weight{id=1, dateRecorded=2023-01-01T10:00, weight=70.5, height=1.75, weightGoal=68.0, weeklyGoal=0.5}";

        // Actual result
        String actual = weight.toString();

        // Comparison
        assertEquals(expected, actual);
    }
}
