package com.martins.helina.exception;

public class ImagemNaoEncontradaException extends RuntimeException {
    public ImagemNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}