package de.htwberlin.webtech.Healthtracker.Entitäsklassen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class StepCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRecorded;
    private int stepCount;
    private int targetStepCount;  // Neues Feld hinzugefügt

    public StepCount() {
    }

    public StepCount(LocalDateTime dateRecorded, int stepCount, int targetStepCount) {
        this.dateRecorded = dateRecorded;
        this.stepCount = stepCount;
        this.targetStepCount = targetStepCount;  // Konstruktor angepasst
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

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getTargetStepCount() {
        return targetStepCount;
    }

    public void setTargetStepCount(int targetStepCount) {
        this.targetStepCount = targetStepCount;
    }

    // Methode zur Berechnung der Differenz
    public int getDifference() {
        return targetStepCount - stepCount;
    }

    @Override
    public String toString() {
        return "StepCount{" +
                "id=" + id +
                ", dateRecorded=" + dateRecorded +
                ", stepCount=" + stepCount +
                ", targetStepCount=" + targetStepCount +
                '}';
    }
}
