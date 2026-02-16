package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import com.Pijamoon.pijamoon_backend.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // permite requisições do front-end (HTML/CSS/JS)
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/adicionar")
    public ProdutoModel adicionarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.salvar(produto);
    }

    //Busca produto por id
    @GetMapping("/buscarPorId/{id}")
    public ProdutoModel buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);

    }
    //Listar todos os produtos
    @GetMapping("/listar")
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listarTodos();
    }

    //AtualizarProduto
    @PutMapping("/atualizarproduto/{id}")
    public ProdutoModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produtoAtualizado) {
        return produtoService.atualizarProduto(id, produtoAtualizado);
    }

    //Deletar Produto
    @DeleteMapping("/Deletarproduto/{id}")
    public void deletarPorid(@PathVariable Long id) {
        produtoService.deletarPorId(id);
    }
}
