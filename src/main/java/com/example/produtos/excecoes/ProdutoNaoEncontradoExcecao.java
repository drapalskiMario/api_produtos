package com.example.produtos.excecoes;

public class ProdutoNaoEncontradoExcecao extends RuntimeException{
    public ProdutoNaoEncontradoExcecao(Long id) {
        super("Produto não encontrado com o ID: " + id);
    }
}
