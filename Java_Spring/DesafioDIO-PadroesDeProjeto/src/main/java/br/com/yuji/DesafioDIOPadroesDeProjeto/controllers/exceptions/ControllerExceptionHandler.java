package br.com.yuji.DesafioDIOPadroesDeProjeto.controllers.exceptions;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.exceptions.LackOfSpaceException;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.exceptions.DatabaseException;
import br.com.yuji.DesafioDIOPadroesDeProjeto.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found...";
        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionResponse exr = new ExceptionResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(exr);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ExceptionResponse> databaseError(DatabaseException e, HttpServletRequest request) {
        String error = "Database error...";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ExceptionResponse exr = new ExceptionResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(exr);
    }

    @ExceptionHandler(LackOfSpaceException.class)
    public ResponseEntity<ExceptionResponse> LackOfSpaceError(LackOfSpaceException e, HttpServletRequest request) {
        String error = "Lack of Space error...";
        HttpStatus status = HttpStatus.BAD_REQUEST;

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
