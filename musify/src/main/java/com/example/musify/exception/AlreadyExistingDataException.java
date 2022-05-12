package com.example.musify.exception;

public class AlreadyExistingDataException extends RuntimeException {
    public AlreadyExistingDataException(String message) {
        super(message);
    }
}
