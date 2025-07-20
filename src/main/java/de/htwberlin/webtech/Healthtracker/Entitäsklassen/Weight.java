package de.htwberlin.webtech.Healthtracker.Entitäsklassen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRecorded;
    private double weight;
    private double height;
    private double weightGoal;
    private double weeklyGoal;

    public Weight() {
    }

    public Weight(LocalDateTime dateRecorded, double weight, double height, double weightGoal, double weeklyGoal) {
        this.dateRecorded = dateRecorded;
        this.weight = weight;
        this.height = height;
        this.weightGoal = weightGoal;
        this.weeklyGoal = weeklyGoal;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public double getWeeklyGoal() {
        return weeklyGoal;
    }

    public void setWeeklyGoal(double weeklyGoal) {
        this.weeklyGoal = weeklyGoal;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "id=" + id +
                ", dateRecorded=" + dateRecorded+
                ", weight=" + weight +
                ", height=" + height +
                ", weightGoal=" + weightGoal +
                ", weeklyGoal=" + weeklyGoal +
                '}';
    }
}
