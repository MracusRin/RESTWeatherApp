package com.mracus.RESTWeatherApp.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorUtil {
    public static void returnErrorsToClient(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();
        List<FieldError> errorList = bindingResult.getFieldErrors();

        for (FieldError error : errorList) {
            errorMsg.append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage() == null ? error.getCode(): error.getDefaultMessage())
                    .append("; ");
        }
        throw new MeasurementException(errorMsg.toString());
    }
}
