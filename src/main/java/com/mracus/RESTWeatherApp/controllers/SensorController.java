package com.mracus.RESTWeatherApp.controllers;

import com.mracus.RESTWeatherApp.dto.SensorDTO;
import com.mracus.RESTWeatherApp.models.Sensor;
import com.mracus.RESTWeatherApp.services.SensorService;
import com.mracus.RESTWeatherApp.util.MeasurementErrorResponse;
import com.mracus.RESTWeatherApp.util.MeasurementException;
import com.mracus.RESTWeatherApp.util.SensorValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.mracus.RESTWeatherApp.util.ErrorUtil.returnErrorsToClient;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    private final SensorService sensorService;
    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;


    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {
        Sensor sensorToAdd = convertToSensor(sensorDTO);
        sensorValidator.validate(sensorToAdd, bindingResult);

        if (bindingResult.hasErrors()) {
            returnErrorsToClient(bindingResult);
        }

        sensorService.save(sensorToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    public Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException exception) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
