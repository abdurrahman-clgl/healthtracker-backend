package de.htwberlin.webtech.Healthtracker.Entitäsklassen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class HeartRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRecorded;
    private int heartRateValue;

    public HeartRate() {
    }

    public HeartRate(LocalDateTime dateRecorded, int heartRateValue) {
        this.dateRecorded = dateRecorded;
        this.heartRateValue = heartRateValue;
    }

    public LocalDateTime getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDateTime dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHeartRateValue() {
        return heartRateValue;
    }

    public void setHeartRateValue(int heartRateValue) {
        this.heartRateValue = heartRateValue;
    }

    @Override
    public String toString() {
        return "HeartRate{" +
                "id=" + id +
                ", dateRecorded=" + dateRecorded +
                ", heartRateValue=" + heartRateValue +
                '}';
    }
}