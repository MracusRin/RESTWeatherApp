package com.mracus.RESTWeatherApp.services;

import com.mracus.RESTWeatherApp.models.Measurement;
import com.mracus.RESTWeatherApp.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Transactional
    public void save(Measurement measurement) {
        enrich(measurement);
        measurementRepository.save(measurement);
    }

    private void enrich(Measurement measurement) {
        measurement.setCreatedAt(LocalDateTime.now());
    }
}
