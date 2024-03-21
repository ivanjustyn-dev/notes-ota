package com.ivanaustria.notesota.exceptions;

public class NotFoundException extends ApplicationException {

    public NotFoundException() {
        super("Note not found!");
    }

}
