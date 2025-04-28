package com.cadastro.api.services;
import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;
import com.cadastro.api.exceptions.TermsNotAcceptedException;
import com.cadastro.api.mapper.PessoaMapper;
import com.cadastro.api.model.Pessoa;
import com.cadastro.api.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class BusinessServiceImpl implements BusinessService {

    private final PessoaRepository repository;
    private final PessoaMapper pessoaMapper;

    public BusinessServiceImpl(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.repository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public PessoaResponse criarPessoa(PessoaCadastroRequest request) {

        if (Boolean.FALSE.equals(request.concordaTermos())) throw new TermsNotAcceptedException();

        Pessoa pessoa = repository.save(pessoaMapper.toPessoa(request));

        return pessoaMapper.toPessoaCadastroResponse(pessoa);
    }
}
