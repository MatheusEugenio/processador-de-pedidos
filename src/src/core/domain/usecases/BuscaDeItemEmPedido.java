package core.domain.usecases;

import core.domain.model.ItemPedido;

import java.util.List;
import java.util.Optional;

public class BuscaDeItemEmPedido {

    public static Optional<ItemPedido> buscaItemEmPedido(ItemPedido itemPedido, List<ItemPedido> produtoList){
        return produtoList.stream()
                .filter(item ->
                        item.getPrecoUnitario() == itemPedido.getPrecoUnitario() &&
                                item.getNomeDoProduto().equalsIgnoreCase(itemPedido.getNomeDoProduto())
                )
                .findFirst();
    }
}
