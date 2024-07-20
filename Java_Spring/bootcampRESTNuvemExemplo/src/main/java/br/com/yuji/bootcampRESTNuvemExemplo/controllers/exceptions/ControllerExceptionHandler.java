package br.com.yuji.bootcampRESTNuvemExemplo.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponse> noSuchElementException(HttpServletRequest request) {
        String error = "Resource not found...";
        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionResponse exr = new ExceptionResponse(Instant.now(), status.value(), error, "Element not found...", request.getRequestURI());

        return ResponseEntity.status(status).body(exr);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        String error = "Illegal entity error...";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        ExceptionResponse exr = new ExceptionResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(exr);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> allExceptions(Exception e, HttpServletRequest request) {
        String error = "Error...";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ExceptionResponse exr = new ExceptionResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(exr);
    }
}
