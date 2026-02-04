package com.Pijamoon.pijamoon_backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produtos")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProdutoModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nome")
private String nome;

@Column(name = "descricao")
private String descricao;

@Column(name = "quantidade")
private Integer quantidade;

@Column(name = "preco")
private double preco;

@Column(name = "imgurl")
private String imgUrl;


}
