package com.mracus.RESTWeatherApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {
    @Id
    @Column(name = "measurement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int measurementId;

    @Column(name = "value")
    @Min(value = -100, message = "Value should not be lower -100")
    @Max(value = 100, message = "Value should not be upper 100")
    @NotNull(message = "Value should not be empty")
    private Float value;

    @Column(name = "raining")
    @NotNull(message = "Raining should not be empty")
    private Boolean raining;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    @NotNull(message = "Sensor should not be empty")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(Sensor sensor, Float value, Boolean raining, LocalDateTime createdAt) {
        this.sensor = sensor;
        this.value = value;
        this.raining = raining;
        this.createdAt = createdAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean isReining() {
        return raining;
    }

    public void setReining(Boolean reining) {
        this.raining = reining;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementId = measurementId;
    }
}
