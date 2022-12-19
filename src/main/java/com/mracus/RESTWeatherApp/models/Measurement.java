package com.mracus.RESTWeatherApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {
    @Id
    @Column(name = "measurement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int measurementId;

    @Column(name = "value")
    @Size(min = -100, max = 100, message = "Value should be between -100 and 100")
    private float value;

    @Column(name = "raining")
    @NotEmpty(message = "Raining should not be empty")
    private boolean reining;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne()
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    private Sensor sensor;

    public Measurement() {}

    public Measurement(Sensor sensor, float value, boolean reining, LocalDateTime createdAt) {
        this.sensor = sensor;
        this.value = value;
        this.reining = reining;
        this.createdAt = createdAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isReining() {
        return reining;
    }

    public void setReining(boolean reining) {
        this.reining = reining;
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
