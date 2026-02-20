package com.Pijamoon.pijamoon_backend.mapper;

import com.Pijamoon.pijamoon_backend.dto.ProdutoDTO;
import com.Pijamoon.pijamoon_backend.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoModel map(ProdutoDTO produtoDTO) {        // TRANSFORMA O MODEL PRA UMA DTO
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produtoDTO.getId());
        produtoModel.setNome(produtoDTO.getNome());
        produtoModel.setDescricao(produtoDTO.getDescricao());
        produtoModel.setPreco(produtoDTO.getPreco());
        produtoModel.setQuantidade(produtoDTO.getQuantidade());
        produtoModel.setImgUrl(produtoDTO.getImgUrl());

        return produtoModel;
    }


    public ProdutoDTO map(ProdutoModel produtoModel) {     // TRANSFORMA A DTO PRO MODEL
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoModel.getId());
        produtoDTO.setNome(produtoModel.getNome());
        produtoDTO.setDescricao(produtoModel.getDescricao());
        produtoDTO.setPreco(produtoModel.getPreco());
        produtoDTO.setQuantidade(produtoModel.getQuantidade());
        produtoDTO.setImgUrl(produtoModel.getImgUrl());

        return produtoDTO;

    }
}