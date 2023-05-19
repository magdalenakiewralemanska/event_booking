package io.mkolodziejczyk92.eventplannerapp.data.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
