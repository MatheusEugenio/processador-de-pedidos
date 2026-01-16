package infra.controller;

import core.model.ItemPedido;
import core.model.Pedido;

public class PedidoController {

    public static void adicionarItemProduto(ItemPedido item, Pedido pedido) {
        try{
            pedido.adicionarItem(item);
            System.out.println("Pedido adicionado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }

    public static void removerItemProduto(ItemPedido item, Pedido pedido) {
        try{
            pedido.removerItem(item);
            System.out.println("Pedido removido com sucesso!");
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }

    public static void editarItemProduto(ItemPedido item, int quant, Pedido pedido) {
        try{
            pedido.editarItem(item, quant);
            System.out.println("Pedido editado com sucesso!");
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
