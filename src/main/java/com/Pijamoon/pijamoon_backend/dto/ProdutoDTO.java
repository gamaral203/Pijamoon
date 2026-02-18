package com.Pijamoon.pijamoon_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {


    private Long id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private double preco;
    private String imgUrl;

}
