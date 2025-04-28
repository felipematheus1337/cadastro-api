package com.cadastro.api.services;
import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;
import com.cadastro.api.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class BusinessServiceImpl implements BusinessService {

    private final PessoaRepository repository;

    public BusinessServiceImpl(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PessoaResponse criarPessoa(PessoaCadastroRequest request) {
        return null;
    }
}
