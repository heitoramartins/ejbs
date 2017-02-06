package com.ejb.exception;


public class CarroNaoEncontradoException extends RuntimeException {
    public CarroNaoEncontradoException(String message) {
        super(message);
    }

    public CarroNaoEncontradoException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
