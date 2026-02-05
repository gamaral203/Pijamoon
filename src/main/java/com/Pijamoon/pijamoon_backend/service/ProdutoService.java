package com.Pijamoon.pijamoon_backend.service;

import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import com.Pijamoon.pijamoon_backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    //Salvar Produto no banco de dados
    public ProdutoModel salvar(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }
}

