package de.htwberlin.webtech.Healthtracker.EntitäsTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodSugar;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloodSugarEntitätsTest {

    @Test
    void testToString() {
        // Input data
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        int bloodSugarValue = 90;

        // Setup the "System Under Test"
        BloodSugar bloodSugar = new BloodSugar(dateRecorded, bloodSugarValue);
        bloodSugar.setId(1L);

        // Expected result
        String expected = "BloodSugar{id=1, dateRecorded=2023-01-01T10:00, bloodSugarLevel=90}";

        // Actual result
        String actual = bloodSugar.toString();

        // Comparison
        assertEquals(expected, actual);
    }
}

