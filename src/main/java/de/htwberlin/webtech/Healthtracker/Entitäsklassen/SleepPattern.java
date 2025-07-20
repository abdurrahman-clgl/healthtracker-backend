package de.htwberlin.webtech.Healthtracker.Entitäsklassen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class SleepPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRecorded;
    private double sleepDuration;
    private double lightSleepDuration;
    private double deepSleepDuration;
    private int interruptions;
    private double sleepQuality;

    public SleepPattern() {
    }

    public SleepPattern(LocalDateTime dateRecorded, double sleepDuration, double lightSleepDuration, double deepSleepDuration, int interruptions) {
        this.dateRecorded = dateRecorded;
        this.sleepDuration = sleepDuration;
        this.lightSleepDuration = lightSleepDuration;
        this.deepSleepDuration = deepSleepDuration;
        this.interruptions = interruptions;
        this.sleepQuality = calculateSleepQuality();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDateTime dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public double getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(double sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public double getLightSleepDuration() {
        return lightSleepDuration;
    }

    public void setLightSleepDuration(double lightSleepDuration) {
        this.lightSleepDuration = lightSleepDuration;
    }

    public double getDeepSleepDuration() {
        return deepSleepDuration;
    }

    public void setDeepSleepDuration(double deepSleepDuration) {
        this.deepSleepDuration = deepSleepDuration;
    }

    public int getInterruptions() {
        return interruptions;
    }

    public void setInterruptions(int interruptions) {
        this.interruptions = interruptions;
    }

    public double getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(double sleepQuality) {
        this.sleepQuality = sleepQuality;
    }

    public double calculateSleepQuality() {
        double quality = (sleepDuration + deepSleepDuration - interruptions * 0.5) / (sleepDuration + lightSleepDuration + deepSleepDuration);
        return Math.max(0, Math.min(100, quality * 100));
    }

    public void updateSleepQuality() {
        this.sleepQuality = calculateSleepQuality();
    }

    @Override
    public String toString() {
        return "SleepPattern{" +
                "id=" + id +
                ", dateRecorded=" + dateRecorded +
                ", sleepDuration=" + sleepDuration +
                ", lightSleepDuration=" + lightSleepDuration +
                ", deepSleepDuration=" + deepSleepDuration +
                ", interruptions=" + interruptions +
                ", sleepQuality=" + sleepQuality +
                '}';
    }
}
