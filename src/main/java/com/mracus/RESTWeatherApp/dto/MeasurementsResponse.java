package com.mracus.RESTWeatherApp.dto;

import java.util.List;

public class MeasurementsResponse {
    private List<MeasurementDTO> measurements;

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurementDTOList) {
        this.measurements = measurementDTOList;
    }
}
