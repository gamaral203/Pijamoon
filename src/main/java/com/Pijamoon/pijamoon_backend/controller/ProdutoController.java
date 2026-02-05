package com.Pijamoon.pijamoon_backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // permite requisições do front-end (HTML/CSS/JS)
public class ProdutoController {


    @PostMapping(name = "/adicionar")
    public String adicionarProduto(){
        return "produto adicionado com sucesso";
    }

    @GetMapping(name = "/listar")
    public String listar(){
        return "produto listado com sucesso";
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
