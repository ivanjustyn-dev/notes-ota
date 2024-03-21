package com.ivanaustria.notesota.exceptions;

public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super("Encountered an error during the process.");
    }

    public ApplicationException(String message) {
        super(message);
    }

}
