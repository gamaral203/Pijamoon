package com.Pijamoon.pijamoon_backend.service;

import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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
    //Buscar Produto Por ID
    public ProdutoModel buscarPorId(Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }
}

