package com.Pijamoon.pijamoon_backend.service;

import com.Pijamoon.pijamoon_backend.dto.ProdutoDTO;
import com.Pijamoon.pijamoon_backend.mapper.ProdutoMapper;
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
    private ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    //Salvar Produto no banco de dados
    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        ProdutoModel produto = produtoMapper.map(produtoDTO);
        produto =  produtoRepository.save(produto);
        return produtoMapper.map(produto);
    }

    //Buscar Produto Por ID
    public ProdutoModel buscarPorId(Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    //Listar produtos
    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    //Deletar Produto
    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }
    //Editar produto
    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoAtualizado) {
       if (produtoRepository.existsById(id)){
       produtoAtualizado.setId(id);
       return produtoRepository.save(produtoAtualizado);
       }
        return null;
    }
}

