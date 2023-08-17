package com.example.produtos.servicos;

import com.example.produtos.dto.ProdutoDTO;
import com.example.produtos.entidades.Produto;
import com.example.produtos.excecoes.ProdutoNaoEncontradoExcecao;
import com.example.produtos.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio repositorio;

    public Produto criarCliente(ProdutoDTO produtoDTO) {
        var produto = new Produto();
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return repositorio.save(produto);
    }

    public List<Produto> listarClientes() {
        return repositorio.findAll();
    }

    public Produto obterClientePorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoExcecao(id));
    }

    public Produto atualizarCliente(Long id, ProdutoDTO produtoDTO) {
        var produto = obterClientePorId(id);
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return repositorio.save(produto);
    }

    public void deletarCliente(Long id) {
        var produto = obterClientePorId(id);
        repositorio.delete(produto);
    }
}
