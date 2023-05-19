package io.mkolodziejczyk92.eventplannerapp.data.exception;

public class EmailExistException extends Exception{

    public EmailExistException(String message) {
        super(message);
    }
}
