package com.cadastro.api.services;

import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;

public interface BusinessService {

    PessoaResponse cadastrarPessoa(PessoaCadastroRequest request);

    PessoaResponse obterPessoaPorId(Long id);
}
