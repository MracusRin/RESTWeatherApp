package com.mracus.RESTWeatherApp.controllers;

import com.mracus.RESTWeatherApp.dto.MeasurementDTO;
import com.mracus.RESTWeatherApp.dto.MeasurementsResponse;
import com.mracus.RESTWeatherApp.models.Measurement;
import com.mracus.RESTWeatherApp.services.MeasurementService;
import com.mracus.RESTWeatherApp.util.MeasurementErrorResponse;
import com.mracus.RESTWeatherApp.util.MeasurementException;
import com.mracus.RESTWeatherApp.util.MeasurementValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.mracus.RESTWeatherApp.util.ErrorUtil.returnErrorsToClient;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;
    private final MeasurementValidator measurementValidator;

    @Autowired
    public MeasurementController(MeasurementService measurementService, ModelMapper modelMapper,
                                 MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
        this.measurementValidator = measurementValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                                          BindingResult bindingResult) {
        Measurement measurementToAdd = convertToMeasurement(measurementDTO);
        measurementValidator.validate(measurementToAdd, bindingResult);

        if (bindingResult.hasErrors()) {
            returnErrorsToClient(bindingResult);
        }

        measurementService.save(measurementToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public MeasurementsResponse getMeasurements() {
        MeasurementsResponse measurementsResponse = new MeasurementsResponse();
        List<MeasurementDTO> measurementList = measurementService
                .findAll()
                .stream()
                .map(this::convertToMeasurementDTO)
                .toList();

        measurementsResponse.setMeasurements(measurementList);
        return measurementsResponse;
    }

    @GetMapping("/rainyDaysCount")
    public Integer getRainyDaysCount() {
        return measurementService.showRainyDaysCount();
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException exception) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

}
