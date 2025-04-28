package com.cadastro.api.mapper;

import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {


    @Mapping(target = "id", ignore = true)
    Endereco toEndereco(PessoaCadastroRequest request);
}

