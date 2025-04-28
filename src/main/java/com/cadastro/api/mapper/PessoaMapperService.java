package com.cadastro.api.mapper;

import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;
import com.cadastro.api.model.Endereco;
import com.cadastro.api.model.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class PessoaMapperService {

    public Pessoa toPessoa(PessoaCadastroRequest request) {

        Endereco endereco = new Endereco();
        endereco.setCep(request.cep());
        endereco.setLogradouro(request.logradouro());
        endereco.setNumero(request.numero());
        endereco.setComplemento(request.complemento());
        endereco.setBairro(request.bairro());
        endereco.setCidade(request.cidade());
        endereco.setEstado(request.estado());

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.nome());
        pessoa.setEmail(request.email());
        pessoa.setTipoPessoa(request.tipoPessoa());
        pessoa.setCpf(request.cpf());
        pessoa.setCnpj(request.cnpj());
        pessoa.setCelular(request.celular());
        pessoa.setTelefone(request.telefone());
        pessoa.setEndereco(endereco);

        return pessoa;
    }

    public PessoaResponse toPessoaCadastroResponse(Pessoa pessoa) {

        return new PessoaResponse(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTipoPessoa());
    }
}
