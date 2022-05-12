package com.example.musify.exception;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log = (Logger) LoggerFactory.getLogger(RestExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegal(IllegalArgumentException i) {

        ApiError apiError = new ApiError(BAD_REQUEST, i.getMessage());
        log.error("Illegal argument: ", i);
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException e) {
        ApiError apiError = new ApiError(NOT_FOUND, e.getMessage());
        log.error("Not found : ", e);
        return new ResponseEntity<>(apiError,NOT_FOUND);
    }
    @ExceptionHandler(AlreadyExistingDataException.class)
    protected ResponseEntity<Object> handleAlreadyExistingDataException(AlreadyExistingDataException e){
        ApiError apiError = new ApiError(BAD_REQUEST, e.getMessage());
        log.error("ALREADY EXISTS:" +e.getMessage());
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }
    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException e){
        ApiError apiError = new ApiError(NOT_FOUND, e.getMessage());
        log.error("DATA NOT FOUND: "+e.getMessage());
        return new ResponseEntity<>(apiError, NOT_FOUND);
    }
    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException e){
        ApiError apiError = new ApiError(UNAUTHORIZED, e.getMessage());
        log.error("UNAUTHORIZED: "+e.getMessage());
        return new ResponseEntity<>(apiError, UNAUTHORIZED);
    }
    @ExceptionHandler(PrivatePlaylistException.class)
    protected ResponseEntity<Object> handlePrivatePlaylistException(PrivatePlaylistException e){
        ApiError apiError = new ApiError(UNAUTHORIZED, e.getMessage());
        log.error("UNAUTHORIZED: "+e.getMessage());
        return new ResponseEntity<>(apiError, UNAUTHORIZED);
    }
    @ExceptionHandler(WrongInputException.class)
    protected ResponseEntity<Object> handleWrongInputException(WrongInputException e){
        ApiError apiError = new ApiError(BAD_REQUEST, e.getMessage());
        log.error("WRONG INPUT: "+e.getMessage());
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorMessages = ex.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ApiError apiError = new ApiError(BAD_REQUEST, errorMessages);
        log.error("Argument not valid: ", ex);
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(INTERNAL_SERVER_ERROR, "Generic Server Error");
        log.error("Generic Error: " + ex);
        return new ResponseEntity<>(apiError, INTERNAL_SERVER_ERROR);
    }
    /*@Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }*/
}
