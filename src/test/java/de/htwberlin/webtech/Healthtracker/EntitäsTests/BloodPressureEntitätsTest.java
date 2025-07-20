package de.htwberlin.webtech.Healthtracker.EntitäsTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.BloodPressure;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BloodPressureTest {

    @Test
    void testToString() {
        // Eingabedaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        int systolicPressure = 120;
        int diastolicPressure = 80;

        // "System under test" aufsetzen
        BloodPressure bloodPressure = new BloodPressure(dateRecorded, systolicPressure, diastolicPressure);
        bloodPressure.setId(42L);

        // Erwartetes Ergebnis
        String expected = "BloodPressure{id=42, dateRecorded=2023-01-01T10:00, systolicPressure=120, diastolicPressure=80}";

        // Tatsächliches Ergebnis
        String actual = bloodPressure.toString();

        // Vergleich
        assertEquals(expected, actual);
    }
}
