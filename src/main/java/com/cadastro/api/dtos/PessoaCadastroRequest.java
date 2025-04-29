package com.cadastro.api.dtos;

import com.cadastro.api.model.TipoPessoa;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaCadastroRequest(

        @NotNull
        TipoPessoa tipoPessoa,

        @NotNull(message = "O nome deve ser informado.")
        String nome,

        @CPF
        String cpf,

        @CNPJ
        String cnpj,

        @Email
        @NotNull(message = "O email deve ser informado.")
        String email,

        @Pattern(regexp = "^[0-9]+$", message = "O celular deve conter apenas números.")
        String celular,

        String telefone,

        @Email
        @NotNull(message = "O email para confirmação deve ser informado.")
        String confirmarEmail,

        @NotNull
        @Pattern(regexp = "^\\d{8}$", message = "CEP deve conter exatamente 8 números")
        String cep,

        @NotNull(message = "O logradouro deve ser informado.")
        String logradouro,

        @NotNull(message = "O numero deve ser informado.")
        String numero,

        String complemento,

        @NotNull(message = "O bairro deve ser informado.")
        String bairro,

        @NotNull(message = "A cidade deve ser informada.")
        String cidade,

        @NotNull(message = "O estado deve ser informado.")
        String estado,

        @NotNull(message = "É necessário concordar com os termos de uso.")
        Boolean concordaTermos
) {}
