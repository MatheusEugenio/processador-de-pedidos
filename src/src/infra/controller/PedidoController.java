package infra.controller;

import core.model.ItemPedido;
import core.usecases.BuscaDeItemEmPedido;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PedidoController {

    public static void adicionarProduto(ItemPedido item, List<ItemPedido> itensNoCarrinho) {
        if (item == null){
            throw new IllegalArgumentException("produto é nulo, inválido!");
        }

        itensNoCarrinho.add(item);
    }

    public static void removerProduto(ItemPedido item, List<ItemPedido> itensNoCarrinho){
        if (item == null){
            throw new IllegalArgumentException("produto ou cliente ou ambos são nulos!");
        }

        itensNoCarrinho.removeIf(itemDalista ->
                itemDalista.getProduto() != null
                        && itemDalista.getProduto().getNome().equalsIgnoreCase(item.getProduto().getNome())
                        && itemDalista.getPrecoUnitario() == item.getPrecoUnitario()
        );
    }

    public static void editarProduto(ItemPedido item, List<ItemPedido> itensNoCarrinho){// tem que ser mais completo
        if (item == null){
            throw new IllegalArgumentException("produto ou cliente ou ambos são nulos!");
        }

        boolean estaNaLista = itensNoCarrinho.contains(item);
        if (!estaNaLista){
            throw new NoSuchElementException("O item "+item.getProduto().getNome()+" não está presente na sua lista de pedidos!");
        }

        Optional<ItemPedido> itemEncontradoOP = BuscaDeItemEmPedido.buscaItemEmPedido(item, itensNoCarrinho);
        ItemPedido itemEncontrado = itemEncontradoOP.orElseThrow(() -> new NoSuchElementException("Erro: Item não encontrado na busca detalhada."));

        //a edição do pedido..
    }
}
