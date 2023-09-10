package io.mkolodziejczyk92.eventplannerapp.data.exception;

public class RepeatedPasswordException extends RuntimeException {
    public RepeatedPasswordException(String message) {
        super(message);
    }
}
