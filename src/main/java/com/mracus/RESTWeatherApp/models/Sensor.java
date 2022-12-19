package com.mracus.RESTWeatherApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @Column(name = "sensor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;

    @Column(name = "name")
    @NotEmpty(message = "Sensor name should not be empty")
    private String name;

    @OneToOne(mappedBy = "sensor", cascade = CascadeType.PERSIST)
    private Measurement measurement;

    public Sensor(){}

    public Sensor(String name) {
        this.name = name;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }
}
