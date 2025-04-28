package com.cadastro.api.exceptions;

public class TermsNotAcceptedException extends RuntimeException {

    private final static String MENSAGEM_ERRO = "É necessário concordar com os termos de uso para realizar o cadastro.";

    public TermsNotAcceptedException() {
        super(MENSAGEM_ERRO);
    }
}
