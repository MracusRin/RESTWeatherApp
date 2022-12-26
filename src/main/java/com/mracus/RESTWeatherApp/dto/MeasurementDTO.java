package com.mracus.RESTWeatherApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {
    @Min(value = -100, message = "Value should not be lower -100")
    @Max(value = 100, message = "Value should not be upper 100")
    @NotNull(message = "Value should not by empty")
    private Float value;

    @JsonProperty("raining")
    @NotNull(message = "1Raining should not be empty")
    private boolean raining;

    @NotNull(message = "Sensor should not be empty")
    private SensorDTO sensor;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public boolean isReining() {
        return raining;
    }

    public void setReining(boolean reining) {
        this.raining = reining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
