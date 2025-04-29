package com.cadastro.api.exceptions;

public class MissingCpfException extends RuntimeException {

    private final static String MENSAGEM_ERRO = "O CPF é obrigatório para pessoas físicas.";

    public MissingCpfException() {
        super(MENSAGEM_ERRO);
    }
}
