package infra.controller;

import core.domain.model.ItemPedido;
import core.domain.services.Pedido;

public class PedidoController {

    /// TALVEZ TENHA QUE COLOCAR UMA LÓGICA DE VERIFICAÇÃO DE EXISTÊNCIA DO PEDIDO, ANTES DE USAR ESSES MÉTODOS
    /// O QUE IMPACTA DIRETAMENTE NA ASSINATURA DESSES MÉTODOS
    public static void adicionarItemProdutoAoPedido(ItemPedido item, Pedido pedido) {
        try{
            pedido.adicionarItem(item);
            System.out.println("Pedido adicionado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }

    public static void removerItemProdutoDoPedido(ItemPedido item, Pedido pedido) {
        try{
            pedido.removerItem(item);
            System.out.println("Pedido removido com sucesso!");
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }

    public static void editarItemProdutoDoPedido(ItemPedido item, int quant, Pedido pedido) {
        try{
            pedido.editarItem(item, quant);
            System.out.println("Pedido editado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }

}
