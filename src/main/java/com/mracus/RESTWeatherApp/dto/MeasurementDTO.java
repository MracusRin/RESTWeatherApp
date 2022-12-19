package com.mracus.RESTWeatherApp.dto;

import com.mracus.RESTWeatherApp.models.Sensor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MeasurementDTO {
    @Size(min = -100, max = 100, message = "Value should be between -100 and 100")
    private float value;

    @NotEmpty(message = "Raining should not be empty")
    private boolean reining;

    private Sensor sensor;

    public MeasurementDTO(float value, boolean reining, Sensor sensor) {
        this.value = value;
        this.reining = reining;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
