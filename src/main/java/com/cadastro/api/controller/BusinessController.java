package com.cadastro.api.controller;

import com.cadastro.api.dtos.PessoaCadastroRequest;
import com.cadastro.api.dtos.PessoaResponse;
import com.cadastro.api.services.BusinessService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    @Tag(name = "Cadastrar Pessoa", description = "Cadastrar pessoa física/jurídica")
    public ResponseEntity<PessoaResponse> cadastrarPessoa(@RequestBody PessoaCadastroRequest request) {
        PessoaResponse response = businessService.cadastrarPessoa(request);

        URI location = URI.create("/api/v1/" + response.id());

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    @Tag(name = "Buscar pessoa", description = "Buscar pessoa pelo Id")
    public ResponseEntity<PessoaResponse> obterPessoaPorId(@PathVariable Long id) {
        PessoaResponse response = businessService.obterPessoaPorId(id);

        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(response);

    }
}
