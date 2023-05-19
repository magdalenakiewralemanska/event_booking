package io.mkolodziejczyk92.eventplannerapp.data.exception;

public class UsernameExistException extends Exception{
    public UsernameExistException(String message) {
        super(message);
    }
}
