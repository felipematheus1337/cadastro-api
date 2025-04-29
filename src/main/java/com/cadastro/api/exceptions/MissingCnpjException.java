package com.cadastro.api.exceptions;

public class MissingCnpjException extends RuntimeException {

    private final static String MENSAGEM_ERRO = "O CNPJ é obrigatório para pessoas jurídicas.";

    public MissingCnpjException() {
        super(MENSAGEM_ERRO);
    }
}
