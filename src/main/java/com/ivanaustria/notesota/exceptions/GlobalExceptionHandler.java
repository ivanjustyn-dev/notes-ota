package com.ivanaustria.notesota.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class, NoResultException.class})
    protected ResponseEntity<Object> notFoundException(Exception ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .timestamp(new Date())
                .status(NOT_FOUND.value())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();

        return handleExceptionInternal(ex, response, new HttpHeaders(), NOT_FOUND, request);
    }

    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<Object> applicationException(ApplicationException ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .timestamp(new Date())
                .status(BAD_REQUEST.value())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();

        return handleExceptionInternal(ex, response, new HttpHeaders(), BAD_REQUEST, request);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> unhandledException(Exception ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .timestamp(new Date())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .message("Encountered internal server error. Please contact our Support team.")
                .build();

        return handleExceptionInternal(ex, response, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

}