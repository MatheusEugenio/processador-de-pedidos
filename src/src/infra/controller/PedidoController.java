package infra.controller;

import core.domain.model.ItemPedido;
import core.domain.model.Pedido;
import infra.util.StatusDoPedido;

public class PedidoController {

    public static void adicionarItemProdutoAoPedido(ItemPedido item, Pedido pedido) {
        if (pedido == null){
            throw new NullPointerException("Erro ao adicionar produto: o pedido ainda não existe ou é nulo!");
        }

        pedido.adicionarItem(item);
        System.out.println("Pedido adicionado com sucesso!");
    }

    public static void removerItemProdutoDoPedido(ItemPedido item, Pedido pedido) {
        if (pedido == null){
            throw new NullPointerException("Erro ao remover produto: o pedido ainda não existe ou é nulo!");
        }

        pedido.removerItem(item);
        System.out.println("Pedido removido com sucesso!");
    }

    public static void editarItemProdutoDoPedido(ItemPedido item, int quant, Pedido pedido) {

        if (pedido == null){
            throw new NullPointerException("Erro ao editar produto: o pedido ainda não existe ou é nulo!");
        }

        pedido.editarItem(item, quant);
        System.out.println("Pedido editado com sucesso!");
    }

    public static void finalizarPedido(Pedido pedido) {

        if (pedido == null || pedido.getItensNoCarrinho().isEmpty()){
            throw new NullPointerException("Erro ao finalizar o pedido: Este pedido encontra-se vazio ou é nulo!");
        }

        pedido.getItensNoCarrinho().clear();
        pedido.setStaus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
    }
}
