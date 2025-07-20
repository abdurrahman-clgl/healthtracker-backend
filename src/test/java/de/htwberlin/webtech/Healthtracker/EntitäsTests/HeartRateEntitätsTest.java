package de.htwberlin.webtech.Healthtracker.EntitäsTests;

import de.htwberlin.webtech.Healthtracker.Entitäsklassen.HeartRate;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeartRateTest {

    @Test
    void testToString() {
        // Eingabedaten
        LocalDateTime dateRecorded = LocalDateTime.of(2023, 1, 1, 10, 0, 0);
        int heartRateValue = 70;

        // "System under test" aufsetzen
        HeartRate heartRate = new HeartRate(dateRecorded, heartRateValue);
        heartRate.setId(42L);

        // Erwartetes Ergebnis
        String expected = "HeartRate{id=42, dateRecorded=2023-01-01T10:00, heartRateValue=70}";

        // Tatsächliches Ergebnis
        String actual = heartRate.toString();

        // Vergleich
        assertEquals(expected, actual);
    }
}
