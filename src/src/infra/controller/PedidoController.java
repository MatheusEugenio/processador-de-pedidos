package infra.controller;

import core.model.ItemPedido;
import core.model.Pedido;
import infra.services.IPagamento;
import infra.services.PagamentoCartao;
import infra.services.PagamentoPix;

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

    public static void finalizarPedido(Pedido pedido, String metodoEscolhido) {
        try {
            IPagamento estrategia;

            switch (metodoEscolhido) {
                case "PIX":
                    estrategia = new PagamentoPix();
                    break;
                case "CARTAO":
                    estrategia = new PagamentoCartao();
                    break;
                default:
                    throw new IllegalArgumentException("Método de pagamento inválido");
            }

            // O pedido processa o pagamento sem saber qual metodo é
            pedido.pagarPedido(estrategia);

        } catch (Exception e) {
            System.out.println("Erro ao pagar: " + e.getMessage());
        }
    }
}
