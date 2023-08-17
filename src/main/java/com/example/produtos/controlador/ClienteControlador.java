package com.example.produtos.controlador;

import com.example.produtos.dto.ProdutoDTO;
import com.example.produtos.entidades.Produto;
import com.example.produtos.servicos.ProdutoServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ClienteControlador {

    @Autowired
    private ProdutoServico servico;

    @PostMapping
    public ResponseEntity<Produto> criarCliente(@RequestBody @Valid ProdutoDTO clienteDTO) {
        var cliente = servico.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarClientes() {
        var clientes = servico.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterClientePorId(@PathVariable Long id) {
        var cliente = servico.obterClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ProdutoDTO clienteDTO) {
        var cliente = servico.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        servico.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
