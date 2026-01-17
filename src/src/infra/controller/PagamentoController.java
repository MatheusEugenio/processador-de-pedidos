package infra.controller;

import core.model.Pedido;
import infra.services.IPagamento;
import infra.services.PagamentoCartao;
import infra.services.PagamentoPix;

public class PagamentoController {

    public static void finalizarPedido(Pedido pedido, String metodoEscolhido) {
        try {
            IPagamento estrategiaDePagamento;

            switch (metodoEscolhido) {
                case "PIX":
                    estrategiaDePagamento = new PagamentoPix();
                    break;
                case "CARTAO":
                    estrategiaDePagamento = new PagamentoCartao();
                    break;
                default:
                    throw new IllegalArgumentException("Método de pagamento inválido");
            }

            // O pedido processa o pagamento sem saber qual metodo de pagamento é
            pedido.pagarPedido(estrategiaDePagamento);

        } catch (Exception e) {
            System.out.println("Erro ao pagar: " + e.getMessage());
        }
    }

}
