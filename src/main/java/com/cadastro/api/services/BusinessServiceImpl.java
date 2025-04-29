package com.cadastro.api.services;
import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;
import com.cadastro.api.exceptions.*;
import com.cadastro.api.mapper.PessoaMapperService;
import com.cadastro.api.model.Pessoa;
import com.cadastro.api.model.TipoPessoa;
import com.cadastro.api.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class BusinessServiceImpl implements BusinessService {

    private final PessoaRepository repository;
    private final PessoaMapperService pessoaMapper;

    public BusinessServiceImpl(PessoaRepository pessoaRepository,
                               PessoaMapperService pessoaMapper) {
        this.repository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public PessoaResponse cadastrarPessoa(PessoaCadastroRequest request) {

        validate(request);

        Pessoa pessoa = repository.save(pessoaMapper.toPessoa(request));

        return pessoaMapper.toPessoaCadastroResponse(pessoa);
    }

    @Override
    public PessoaResponse obterPessoaPorId(Long id) {
        return repository.findById(id)
                .map(pessoaMapper::toPessoaCadastroResponse)
                .orElse(null);
    }

    private void validate(PessoaCadastroRequest request) {
        if (Objects.equals(request.concordaTermos(), Boolean.FALSE)) throw new TermsNotAcceptedException();
        if (!Objects.equals(request.email(), request.confirmarEmail())) throw new EmailsDoNotMatchException();
        if (repository.existsByEmail(request.email())) throw new EmailAlreadyExistsException();
        if (TipoPessoa.FISICA.equals(request.tipoPessoa()) && (request.cpf() == null || request.cpf().isBlank()))
            throw new MissingCpfException();

        if (TipoPessoa.JURIDICA.equals(request.tipoPessoa()) && (request.cnpj() == null || request.cnpj().isBlank()))
            throw new MissingCnpjException();

    }
}
