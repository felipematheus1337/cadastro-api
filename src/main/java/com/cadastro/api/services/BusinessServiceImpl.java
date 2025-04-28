package com.cadastro.api.services;
import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;
import com.cadastro.api.exceptions.TermsNotAcceptedException;
import com.cadastro.api.mapper.PessoaMapperService;
import com.cadastro.api.model.Pessoa;
import com.cadastro.api.repositories.PessoaRepository;
import org.springframework.stereotype.Service;


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

        if (request.concordaTermos() != null && Boolean.FALSE.equals(request.concordaTermos())) throw new TermsNotAcceptedException();

        Pessoa pessoa = repository.save(pessoaMapper.toPessoa(request));

        return pessoaMapper.toPessoaCadastroResponse(pessoa);
    }

    @Override
    public PessoaResponse obterPessoaPorId(Long id) {
        return repository.findById(id)
                .map(pessoaMapper::toPessoaCadastroResponse)
                .orElse(null);
    }
}
