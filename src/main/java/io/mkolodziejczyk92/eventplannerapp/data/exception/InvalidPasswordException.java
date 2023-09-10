package io.mkolodziejczyk92.eventplannerapp.data.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
