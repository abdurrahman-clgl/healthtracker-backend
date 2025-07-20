package de.htwberlin.webtech.Healthtracker.Entitäsklassen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class BloodSugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRecorded;
    private int bloodSugarLevel;

    public BloodSugar() {
    }

    public BloodSugar(LocalDateTime dateRecorded, int bloodSugarLevel) {
        this.dateRecorded = dateRecorded;
        this.bloodSugarLevel = bloodSugarLevel;
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

    public int getBloodSugarLevel() {
        return bloodSugarLevel;
    }

    public void setBloodSugarLevel(int bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }

    @Override
    public String toString() {
        return "BloodSugar{" +
                "id=" + id +
                ", dateRecorded=" + dateRecorded +
                ", bloodSugarLevel=" + bloodSugarLevel +
                '}';
    }
}
