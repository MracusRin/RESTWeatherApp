package com.mracus.RESTWeatherApp.dto;

import com.mracus.RESTWeatherApp.models.Sensor;
import jakarta.validation.constraints.*;

public class MeasurementDTO {
    @Min(value = -100, message = "Value should not be lower -100")
    @Max(value = 100, message = "Value should not be upper 100")
    @NotNull(message = "Value should not by empty")
    private Float value;

    @NotNull(message = "Raining should not be empty")
    private Boolean raining;

    @NotNull(message = "Sensor should not be empty")
    private Sensor sensor;

    public MeasurementDTO(Float value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
