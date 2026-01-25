package aplication;

import core.domain.model.*;
import core.domain.model.Pedido;
import core.domain.strategies.RegraEletronico;
import core.domain.strategies.RegraLivros;
import infra.controller.PagamentoController;
import infra.controller.PedidoController;
import infra.util.MetodosDePagamentos;

public class app {
    public static void main(String[] args) {
        /// RECEBER O PEDIDO
        Cliente junior = new Cliente("Junior Bala", 12345678910L, 40, "12/12/2000", 1000.0);

        RegraEletronico regraEletronico = new RegraEletronico();
        RegraLivros regraLivros = new RegraLivros();
        Produto produto1 = new ProdutoFisico("Televisão", "televisão samsung", 580.40,1440, 10, regraEletronico);
        Produto produto2 = new ProdutoDigital("Como ficar rico em 50 dias", "ebook digital", 39.99, 9, regraLivros);

        ItemPedido televisao = new ItemPedido(produto1);
        ItemPedido ebook = new ItemPedido(produto1);

        Pedido pedido = new Pedido(junior);
        try {
            PedidoController.adicionarItemProdutoAoPedido(televisao, pedido);
            PedidoController.adicionarItemProdutoAoPedido(ebook, pedido);

            /*
            PedidoController.editarItemProdutoDoPedido(televisao, -1, pedido);
            PedidoController.removerItemProdutoDoPedido(ebook, pedido);
             */

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        /// PROCESSA O PAGAMENTO

        try {
            PagamentoController.pagarDoPedido(pedido, MetodosDePagamentos.PIX);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        ///CALCULA O FRETE
        /// NOTIFICA O CLIENTE
    }
}
