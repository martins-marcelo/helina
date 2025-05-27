package com.martins.helina.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.martins.helina.exception.ImagemNaoEncontradaException;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ImagemNaoEncontradaException.class)
    public ResponseEntity<String> handleFotoNaoEncontrada(ImagemNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + ex.getMessage());
    }
}