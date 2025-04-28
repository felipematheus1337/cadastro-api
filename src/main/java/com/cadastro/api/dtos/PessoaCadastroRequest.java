package com.cadastro.api.dtos;

import com.cadastro.api.model.TipoPessoa;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaCadastroRequest(

        @NotNull
        TipoPessoa tipoPessoa,

        @NotNull
        String nome,

        @CPF
        String cpf,

        @CNPJ
        String cnpj,

        @Email
        @NotNull
        String email,

        String celular,

        String telefone,

        @Email
        @NotNull
        String confirmarEmail,

        @NotNull
        String cep,

        @NotNull
        String logradouro,

        @NotNull
        String numero,

        String complemento,

        @NotNull
        String bairro,

        @NotNull
        String cidade,

        @NotNull
        String estado,

        @NotNull
        Boolean concordaTermos
) {}
