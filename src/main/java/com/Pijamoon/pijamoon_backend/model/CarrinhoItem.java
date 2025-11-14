package com.Pijamoon.pijamoon_backend.model;

public class CarrinhoItem {
    private Long idProduto;
    private String nome;
    private double preco;
    private int quantidade;

    public CarrinhoItem(Long idProduto, String nome, double preco, int quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getIdProduto() { return idProduto; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }
}
