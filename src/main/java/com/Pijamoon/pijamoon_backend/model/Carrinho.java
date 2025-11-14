package com.Pijamoon.pijamoon_backend.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<CarrinhoItem> itens = new ArrayList<>();

    public List<CarrinhoItem> getItens() {
        return itens;
    }

    public double getTotal() {
        return itens.stream().mapToDouble(com.Pijamoon.pijamoon_backend.model.CarrinhoItem::getSubtotal).sum();
    }

    public double getFrete() {
        return getTotal() >= 150 ? 0 : 20; // exemplo
    }

    public double getTotalGeral() {
        return getTotal() + getFrete();
    }
}
