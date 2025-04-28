package com.cadastro.api.services;

import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;

public interface BusinessService {

    PessoaResponse criarPessoa(PessoaCadastroRequest request);
}
