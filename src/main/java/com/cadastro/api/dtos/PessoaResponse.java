package com.cadastro.api.dtos;

import com.cadastro.api.model.TipoPessoa;

public record PessoaResponse (Long id, String nome, String email, TipoPessoa tipoPessoa) {
}
