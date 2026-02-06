package com.Pijamoon.pijamoon_backend.controller;

import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import com.Pijamoon.pijamoon_backend.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // permite requisições do front-end (HTML/CSS/JS)
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping(name = "/adicionar")
    public ProdutoModel adicionarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.salvar(produto);
    }

    //Busca produto por id
    @GetMapping(name = "/buscarPorId/{id}")
    public ProdutoModel buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);

    }
    @PutMapping(name = "/editarPorID")
    public String editarComID(){
        return "produto editado com sucesso";
    }
    @DeleteMapping(name = "/deletarPorID")
        public String deletarPorid() {
        return "Produto deletado";
    }
}
