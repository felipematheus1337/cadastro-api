package com.cadastro.api.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    private final static String MENSAGEM_ERRO = "Email já cadastrado.";

    public EmailAlreadyExistsException() {
        super(MENSAGEM_ERRO);
    }
}
