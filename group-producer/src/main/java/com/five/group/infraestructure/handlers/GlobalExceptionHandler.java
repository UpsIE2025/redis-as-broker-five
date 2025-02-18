package com.five.group.infraestructure.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.five.group.domain.exceptions.InvalidDataException;
import com.five.group.domain.model.Error;
import com.five.group.domain.model.ErrorDetail;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<Error> invalidDataException(InvalidDataException ex) {
        Error error = new Error();
        error.setTitle("Invalid params");
        error.setDetail(ex.getMessage());

        error.setErrors(Collections.emptyList());
        List<ErrorDetail> errorDetails = new ArrayList<>();
        ex.getErrors().forEach((key, detail) -> {
            ErrorDetail errorDetail = new ErrorDetail();
            errorDetail.setMessage(key + " " + detail);
            errorDetails.add(errorDetail);
        });
        error.setErrors(errorDetails);
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
