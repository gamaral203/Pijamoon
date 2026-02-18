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
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    //Criar Produto no banco de dados
    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        ProdutoModel produto = produtoMapper.map(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.map(produto);
    }

    //Buscar Produto Por ID
    public ProdutoDTO buscarPorId(Long id) {
        Optional<ProdutoModel> produtoPorId = produtoRepository.findById(id);
        return produtoPorId.map(produtoMapper::map).orElse(null);
    }

    //Listar produtos
    public List<ProdutoDTO> listarTodos() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produtoMapper::map)
                .collect(Collectors.toList());

    }

    //Deletar Produto
    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    //Atualizar produto
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Optional<ProdutoModel> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            ProdutoModel produtoAtualizado = produtoMapper.map(produtoDTO);
            produtoAtualizado.setId(id);
            ProdutoModel produtoSave = produtoRepository.save(produtoAtualizado);
            return produtoMapper.map(produtoAtualizado);
        }
        return null;
    }
}

