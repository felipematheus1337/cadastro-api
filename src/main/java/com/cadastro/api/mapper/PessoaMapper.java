package com.cadastro.api.mapper;

import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;
import com.cadastro.api.model.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class})
public interface PessoaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "endereco", source = "request")
    Pessoa toPessoa(PessoaCadastroRequest request);

    PessoaResponse toPessoaCadastroResponse(Pessoa pessoa);
}
