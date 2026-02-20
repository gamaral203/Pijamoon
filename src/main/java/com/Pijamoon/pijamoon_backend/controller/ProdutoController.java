package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.dto.ProdutoDTO;
import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import com.Pijamoon.pijamoon_backend.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> adicionarProduto(@RequestBody ProdutoDTO produto) {
        ProdutoDTO novoProduto = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto cadastrado com sucesso: " + novoProduto.getNome() + " Id: " + novoProduto.getId());
    }


    //Busca produto por id
    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        ProdutoDTO produto = produtoService.buscarPorId(id);

        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com o Id " + id + "não foi encontrado");
        }

    }

    //Listar todos os produtos
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    //AtualizarProduto
    @PutMapping("/atualizarproduto/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoAtualizado) {
        ProdutoDTO novoProduto = produtoService.salvar(produtoAtualizado);

        if (novoProduto != null) {
            return ResponseEntity.ok(novoProduto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com o Id: " + id + " Não foi encontrado");
        }
    }

    //Deletar Produto
    @DeleteMapping("/Deletarproduto/{id}")
    public ResponseEntity<String> deletarPorid(@PathVariable Long id) {
        if (produtoService.buscarPorId(id) != null) {
            produtoService.deletarPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Produto Com o id: " + id + " deletado com sucesso");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com o id: " + id + " nao encontrado");
        }
    }
}
