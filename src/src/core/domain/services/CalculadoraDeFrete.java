package core.domain.services;

import core.domain.interfaces.ITransportavel;
import core.domain.model.ItemPedido;

import java.util.List;

public class CalculadoraDeFrete {

    public double calcularFreteTotal(List<ItemPedido> itens){
        if (itens.isEmpty()){
            throw new IllegalArgumentException("Nenhum item encontrado, a lista de itens está vazia!");
        }

        return itens.stream()
                .map(ItemPedido::getProduto)
                .filter( produto -> produto instanceof ITransportavel)
                .mapToDouble(produto -> ((ITransportavel) produto).calcularFrete())
                .sum();
    }
}
