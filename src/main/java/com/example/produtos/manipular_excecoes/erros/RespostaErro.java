package com.example.produtos.manipular_excecoes.erros;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostaErro {

    private List<String> erros;

    public RespostaErro(BindingResult bindingResult) {
        this.erros = new ArrayList<>();
        bindingResult
                .getAllErrors()
                .forEach(error -> this.erros.add(error.getDefaultMessage()));
    }

    public RespostaErro(String message) {
        this.erros = Arrays.asList(message);
    }

    public List<String> getErrors() {
        return erros;
    }
}
