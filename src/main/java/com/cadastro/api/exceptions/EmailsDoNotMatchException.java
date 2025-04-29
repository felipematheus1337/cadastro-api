package com.cadastro.api.exceptions;

public class EmailsDoNotMatchException extends RuntimeException {

    private final static String MENSAGEM_ERRO = "Os e-mails não coincidem. Por favor, verifique e tente novamente.";

    public EmailsDoNotMatchException() {
        super(MENSAGEM_ERRO);
    }
}
