package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.controllers.exceptions;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.exceptions.AccountNotExistException;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.exceptions.InsufficientFundsException;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.exceptions.DatabaseException;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.exceptions.ResourceNotFoundException;
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

    @ExceptionHandler(AccountNotExistException.class)
    public ResponseEntity<ExceptionResponse> accountNotExistException(AccountNotExistException e, HttpServletRequest request) {
        String error = "Account not exist error...";
        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionResponse exr = new ExceptionResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(exr);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ExceptionResponse> insufficientFundsException(InsufficientFundsException e, HttpServletRequest request) {
        String error = "Insufficient funds error...";
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;

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
