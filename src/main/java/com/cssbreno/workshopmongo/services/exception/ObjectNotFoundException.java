package com.cssbreno.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg); //chama o construtor da classe pai (RuntimeException) passando a mensagem de erro
    }
}
