package com.mracus.RESTWeatherApp.services;

import com.mracus.RESTWeatherApp.models.Measurement;
import com.mracus.RESTWeatherApp.models.Sensor;
import com.mracus.RESTWeatherApp.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        enrich(measurement);
        measurementRepository.save(measurement);
    }

    private void enrich(Measurement measurement) {
        Sensor sensor = sensorService.findByName(measurement.getSensor().getName()).get();
        measurement.setSensor(sensor);
        measurement.setCreatedAt(LocalDateTime.now());
    }
}
