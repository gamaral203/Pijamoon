package com.Pijamoon.pijamoon_backend.service;

import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import com.Pijamoon.pijamoon_backend.model.UserModel;
import com.Pijamoon.pijamoon_backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

