package core.usecases;

import core.model.ItemPedido;

import java.util.List;
import java.util.Optional;

public class BuscaDeItemEmPedido {

    public static Optional<ItemPedido> buscaItemEmPedido(ItemPedido itemPedido, List<ItemPedido> produtoList){
        return produtoList.stream()
                .filter(itemDaLista -> itemDaLista.getPrecoUnitario() == itemPedido.getPrecoUnitario()
                        && itemDaLista.getProduto().getNome().equalsIgnoreCase(itemPedido.getProduto().getNome()))
                .findFirst();
    }
}
