package infra.controller;

import core.domain.services.Pedido;
import core.domain.interfaces.IPagamento;
import infra.gateways.PagamentoCartao;
import infra.gateways.PagamentoPix;
import infra.util.MetodosDePagamentos;

public class PagamentoController {

    /// LEMBRAR DE FORMATAR A ENTRADA DO "metodoEscolhido" PARA .TRIM().TOUPPERCASE()
    public static void pagamentoDoPedido(Pedido pedido, MetodosDePagamentos metodoEscolhido) throws IllegalArgumentException{
            IPagamento estrategiaDePagamento;

            switch (metodoEscolhido) {
                case PIX:
                    estrategiaDePagamento = new PagamentoPix();
                    break;
                case CARTAO:
                    estrategiaDePagamento = new PagamentoCartao();
                    break;
                default:
                    throw new IllegalArgumentException("Erro ao pagar: Método de pagamento inválido");
            }

            // O pedido processa o pagamento sem saber qual metodo de pagamento é
            pedido.pagarPedido(estrategiaDePagamento);
    }

}
